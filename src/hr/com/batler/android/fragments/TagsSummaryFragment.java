package hr.com.batler.android.fragments;

import hr.com.batler.android.BatlerApplication;
import hr.com.batler.android.R;
import hr.com.batler.android.contentprovider.BatlerContract;
import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class TagsSummaryFragment extends Fragment implements
		OnClickListener,
		LoaderCallbacks<Cursor> {

	public interface OnTagsSummarySelectedListener {
		public void onTagsSelected();
	}

	public static final String TAG = TagsSummaryFragment.class.toString();

	private BatlerApplication app;
	private OnTagsSummarySelectedListener tagsSelectedListener;
	private TextView tagsCount;

	private View fragmentContainerView;

	private static final int LOAD_TAGS = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.fragmentContainerView = inflater.inflate(
				R.layout.fragment_tags_summary,
				container,
				false);

		tagsCount = (TextView) fragmentContainerView
				.findViewById(R.id.summary_count_tv);
		retireveTagsData();

		return this.fragmentContainerView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		try {
			tagsSelectedListener = (OnTagsSummarySelectedListener) activity;
			app = (BatlerApplication) activity.getApplication();
		} catch (ClassCastException e) {
			throw new ClassCastException(
					app.getResourceHandler()
							.getErrorMessage(
									R.string.error_not_implemented_fragment_interface,
									activity.toString(),
									TagsSummaryFragment.OnTagsSummarySelectedListener.class));
		}

	}

	@Override
	public void onResume() {
		this.fragmentContainerView.setOnClickListener(this);
		super.onResume();
	}

	private void retireveTagsData() {
		getLoaderManager().initLoader(LOAD_TAGS, null, this);
	}

	@Override
	public void onClick(View arg0) {
		tagsSelectedListener.onTagsSelected();

	}

	// LOADER CALLBACKS
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		CursorLoader cursorLoader = new CursorLoader(getActivity(),
				BatlerContract.Tag.CONTENT_URI,
 null, null, null,
				null);
		return cursorLoader;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		// tagsCount.setText("123");
		// Log.i(TAG, Integer.toString(data.getCount()));
		tagsCount.setText(Integer.toString(data.getCount()));

	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		tagsCount.setText("0");

	}

	// LOADER CALLBACKS

}
