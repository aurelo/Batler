package hr.com.batler.android.contentprovider;

import android.net.Uri;
import android.provider.BaseColumns;

public final class BatlerContract {

	public static final String AUTHORITY = "hr.com.batler.android.contentprovider";
	public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

	public static final class Tag {
		public interface TagColumns {
			public static final String NAME = "name";
			public static final String DESCRIPTION = "description";
			public static final String[] ALL_COLUMNS = new String[] {
					BaseColumns._ID, BatlerContract.Tag.TagColumns.NAME,
					BatlerContract.Tag.TagColumns.DESCRIPTION };
		}
	}

}
