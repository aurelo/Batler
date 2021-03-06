package hr.com.batler.android;

import hr.com.batler.android.fragments.TagsSummaryFragment.OnTagsSummarySelectedListener;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class DashboardActivity extends Activity implements
		OnTagsSummarySelectedListener {


	private Fragment tagsSummaryFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		tagsSummaryFragment = getFragmentManager().findFragmentById(
				R.id.fragment_tags_summary);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
	/**
	 * Implementation for OnTagsSummarySelectedListener
	 * */
	@Override
	public void onTagsSelected() {
		Toast.makeText(this, R.string.dummy_click_message, Toast.LENGTH_SHORT)
				.show();
	}

}
