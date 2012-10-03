package hr.com.batler.android.model.tables;

import hr.com.batler.android.R;
import hr.com.batler.android.contentprovider.BatlerContract;
import hr.com.batler.android.contentprovider.DescColumns;
import hr.com.batler.android.contentprovider.WhenColumns;
import hr.com.batler.android.resources.ResourceHandler;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;

public class TagTable extends Table implements BaseColumns, WhenColumns, BatlerContract.Tag.TagColumns{

	private static final String TAG = TagTable.class.toString();

	public static final String TABLE_TAGS = "tags";

	private static final String TAGS_TABLE_CREATE_SQL = String.format(
"create table %s (%s integer primary key autoincrement, %s text unique, %s text, %s real, %s real)",
			TABLE_TAGS, BaseColumns._ID, DescColumns.NAME,
			DescColumns.DESCRIPTION, WhenColumns.CREATION_DATE, WhenColumns.LAST_UPDATE_DATE);
	
	private static final String TAGS_TABLE_DROP_SQL = String.format(
			"drop table if exists %s", TABLE_TAGS);




	public static void onCreate(SQLiteDatabase db) {
		db.execSQL(TAGS_TABLE_CREATE_SQL);
	}

	public static void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion){
		db.execSQL(TAGS_TABLE_DROP_SQL);
		onCreate(db);
	}
	
	
	public TagTable(ResourceHandler rh){
		super(rh);
		queryBuilder.setTables(TABLE_TAGS);
	}
	

/*	public SQLiteQueryBuilder queryAll() {
		return queryBuilder;
	}

	@Override
	public SQLiteQueryBuilder queryById(String id) {
		queryBuilder.appendWhereEscapeString(restrinctOnId(id));
		return queryBuilder;
	}
	*/

	
	public SQLiteQueryBuilder query(String[] projection, String selection, String[] selectionArgs, String sortOrder){
		projectionContainsValidColumns(projection);
		
		queryBuilder.buildQuery(projection, selection, null, null, sortOrder, null);
		return queryBuilder;
	}
	;

	public static Uri insert(SQLiteDatabase database, ContentValues values) {
		long rowId;
		Uri returnUri = null;
		Table.addWhenColumnsToContentValuesForInsert(values);
		rowId = database.insert(TagTable.TABLE_TAGS, null, values);
		if (rowId != -1 && rowId > 0) {
			returnUri = ContentUris.withAppendedId(
					BatlerContract.Tag.CONTENT_URI, rowId);
		}
		return returnUri;
	}

	private void projectionContainsValidColumns(String[] projection) {
		if (!TabUtils.projectionContainsValidColumns(projection,
				BatlerContract.Tag.TagColumns.ALL_COLUMNS)){
			throw new IllegalArgumentException(resourceHandler.getErrorMessage(R.string.error_invalid_projection, TagTable.TABLE_TAGS, projection.toString()));
		}
	}
	

}
