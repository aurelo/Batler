package hr.com.batler.android.model.tables;

import android.provider.BaseColumns;

public interface Queryable {

	public static final String ORDER_BY_ID_DESC = String.format("%s DESC",
			BaseColumns._ID);
	public static final String ORDER_BY_ID_ASC = String.format("%s DESC",
			BaseColumns._ID);

	public static final String[] PK_PROJECTION = new String[] { BaseColumns._ID };

	public String queryAll();

	public String queryById(int id);

	public boolean projectionContainsValidColumns(String[] projection);
}
