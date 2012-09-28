package hr.com.batler.android.contentprovider;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class BatlerContract {

	public static final String FORWARDSLASH = "/";
	
	// the scheme part of the provider's URI
	private static final String SCHEME = "content://";
	
	public  static final String AUTHORITY = "hr.com.batler.android.contentprovider";
	public  static final Uri AUTHORITY_URI = Uri.parse(SCHEME + AUTHORITY);

	public static final class Tag {
		
		public static final String BASE_PATH = "tags";
		public static final Uri CONTENT_URI = Uri.parse(SCHEME+AUTHORITY+FORWARDSLASH+BASE_PATH);
		
		public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		public static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		
		
		public interface TagColumns {
			public static final String NAME = "name";
			public static final String DESCRIPTION = "description";
			public static final String[] ALL_COLUMNS = new String[] {
					BaseColumns._ID, BatlerContract.Tag.TagColumns.NAME,
					BatlerContract.Tag.TagColumns.DESCRIPTION };
		}
	}

}
