package hr.com.batler.android.model.tables;

import hr.com.batler.android.contentprovider.BatlerContract;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;

public class TagTable implements BaseColumns, BatlerContract.Tag.TagColumns,
		Queryable {

	public static final String TABLE_TAGS = "tags";

	private static final String TAGS_TABLE_CREATE_SQL = String.format(
			"create table %s (%s primary key autoincrement, %s text, %s text)",
			TABLE_TAGS, BaseColumns._ID, BatlerContract.Tag.TagColumns.NAME,
			BatlerContract.Tag.TagColumns.DESCRIPTION);
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

	@Override
	public String queryAll() {
		return SQLiteQueryBuilder.buildQueryString(false, TABLE_TAGS, null,
				null,
				null,
 null, ORDER_BY_ID_DESC, null);
	}

	@Override
	public String queryById(int id) {
		return SQLiteQueryBuilder.buildQueryString(false, TABLE_TAGS,
				PK_PROJECTION, Integer.toString(id), null, null, null, null);
	}

	@Override
	public boolean projectionContainsValidColumns(String[] projection) {
		return TabUtils.projectionContainsValidColumns(projection,
				BatlerContract.Tag.TagColumns.ALL_COLUMNS);
	}

}
