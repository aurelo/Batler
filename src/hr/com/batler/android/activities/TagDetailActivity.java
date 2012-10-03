package hr.com.batler.android.activities;

import hr.com.batler.android.R;
import hr.com.batler.android.contentprovider.BatlerContract;
import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TagDetailActivity extends Activity implements OnClickListener {

	private TextView tagName;
	private TextView tagDescription;
	private Button saveTag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tag_detail);

		setUpViews();
	}


	@Override
	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.tag_detail_save:
			insertTag();
			break;

		default:
			break;
		}
	}

	private void insertTag() {

		if (tagName.getText() == null) {
			Toast.makeText(this, "Please eneter tag name", Toast.LENGTH_SHORT)
					.show();
			return;
		}

		Uri newRowUri;
		ContentValues values = new ContentValues();

		String tagNameString = tagName.getText().toString();
		String tagDescString = tagDescription.getText().toString();

		values.put(BatlerContract.Tag.TagColumns.NAME, tagNameString);
		values.put(BatlerContract.Tag.TagColumns.DESCRIPTION, tagDescString);

		newRowUri = getContentResolver().insert(BatlerContract.Tag.CONTENT_URI,
				values);

		if (newRowUri != null) {
			Toast.makeText(this, "Tag saved new uri: " + newRowUri.toString(),
					Toast.LENGTH_SHORT).show();
		}
 else {
			Toast.makeText(this, "Tag NOT saved!", Toast.LENGTH_SHORT).show();
		}

	}

	private void setUpViews() {
		tagName = (TextView) findViewById(R.id.tag_detail_tag_name);
		tagDescription = (TextView) findViewById(R.id.tag_detail_tag_description);
		saveTag = (Button) findViewById(R.id.tag_detail_save);
		saveTag.setOnClickListener(this);
	}
}
