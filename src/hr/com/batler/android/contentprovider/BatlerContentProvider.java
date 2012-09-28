package hr.com.batler.android.contentprovider;

import hr.com.batler.android.R;
import hr.com.batler.android.model.BatlerDbHelper;
import hr.com.batler.android.model.tables.Queryable;
import hr.com.batler.android.model.tables.Table;
import hr.com.batler.android.model.tables.TagTable;
import hr.com.batler.android.resources.ResourceHandler;

import java.util.HashMap;
import java.util.Map;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class BatlerContentProvider extends ContentProvider {

	private BatlerDbHelper database;
	private ResourceHandler resHandler;
	
	
	private static final String FORWARDSLASH_PLUS_HASH = "/#";
	
	/**Codes for uri matching*/
	private static final int TAGS = 1000;
	private static final int TAG_ID = 1010;
	
	
	private static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
	
	static {
		matcher.addURI(BatlerContract.AUTHORITY, BatlerContract.Tag.BASE_PATH, TAGS);
		matcher.addURI(BatlerContract.AUTHORITY, BatlerContract.Tag.BASE_PATH + FORWARDSLASH_PLUS_HASH, TAG_ID);
	}
	

	@Override
	public boolean onCreate() {
		database = new BatlerDbHelper(getContext());
		resHandler = new ResourceHandler(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		switch (matcher.match(uri)) {
		case TAGS:
			qb = new TagTable(resHandler).getBaseQueryBuilder();
			break;
        case TAG_ID:
        	qb = new TagTable(resHandler).getBaseQueryBuilder();
        	qb.appendWhere(Table.restrinctOnId(uri.getLastPathSegment()));
			break;
		default:
			throw new IllegalArgumentException(resHandler.getErrorMessage(R.string.error_unknown_uri, uri));
		}
		
		SQLiteDatabase db = openForRead();
		return qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		SQLiteDatabase db = openForWrite();
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		switch (matcher.match(uri)) {
		case TAGS:
			return BatlerContract.Tag.CONTENT_TYPE;
		case TAG_ID:
			return BatlerContract.Tag.CONTENT_ITEM_TYPE;
		default:
			throw new IllegalArgumentException(resHandler.getErrorMessage(R.string.error_unknown_uri, uri));
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = openForWrite();
		return null;
	}



	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		SQLiteDatabase db = openForWrite();
		return 0;
	}

	private SQLiteDatabase openForRead() {
		return database.getReadableDatabase();
	}

	private SQLiteDatabase openForWrite() {
		return database.getWritableDatabase();
	}
	
	static class TableNameClassNameMapper {

		protected static Map<String, Class<? extends Queryable>> mapper = new HashMap<String, Class<? extends Queryable>>();

		static {
			mapper.put(TagTable.TABLE_TAGS, TagTable.class);
		}

	}
	
}
