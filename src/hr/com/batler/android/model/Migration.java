package hr.com.batler.android.model;

import hr.com.batler.android.model.tables.TagTable;
import android.database.sqlite.SQLiteDatabase;

class Migration {
	public static void onCreate(SQLiteDatabase db) {
		// first create master tables - tables with no references
		TagTable.onCreate(db);
	}

	public static void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion) {

		// drop master tables last
		TagTable.onUpgrade(db, oldVersion, newVersion);
	}
}
