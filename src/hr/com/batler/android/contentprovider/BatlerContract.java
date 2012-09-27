package hr.com.batler.android.contentprovider;

import android.net.Uri;

public final class BatlerContract {

	public static final String AUTHORITY = "hr.com.batler.android.contentprovider";
	public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

}
