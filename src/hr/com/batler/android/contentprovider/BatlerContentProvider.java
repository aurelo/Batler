package hr.com.batler.android.contentprovider;

import hr.com.batler.android.model.BatlerDbHelper;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class BatlerContentProvider extends ContentProvider {

	private BatlerDbHelper database;

	@Override
	public boolean onCreate() {
		database = new BatlerDbHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {

		SQLiteDatabase db = openForRead();
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	private SQLiteDatabase openForRead() {
		return database.getReadableDatabase();
	}

	private SQLiteDatabase openForWrite() {
		return database.getWritableDatabase();
	}

}
