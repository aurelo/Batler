package hr.com.batler.android.model.tables;

import hr.com.batler.android.resources.ResourceHandler;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;

public abstract class Table implements Queryable{
	
	protected ResourceHandler resourceHandler;
	protected SQLiteQueryBuilder queryBuilder;
	
	protected static final String TAB_COUNT_SQL = "select count(*) from %s";

	public static final String ORDER_BY_ID_DESC = String.format("%s DESC",
			BaseColumns._ID);
	public static final String ORDER_BY_ID_ASC = String.format("%s ASC",
			BaseColumns._ID);
	
	
	public static final String DEFAULT_SORT_ORDER = ORDER_BY_ID_DESC;

	public static final String[] PK_PROJECTION = new String[] { BaseColumns._ID };
	
	public static final String RESTRICT_ON_ID = BaseColumns._ID + " = %s";
	
	//public abstract SQLiteQueryBuilder query(String[] projection, String selection, String[] selectionArgs, String sortOrder);
	
	//public abstract boolean projectionContainsValidColumns(String[] projection);
	
	public static String restrinctOnId(String id){
		return String.format(RESTRICT_ON_ID, id);
	}

	
	public Table(ResourceHandler rh){
		this.resourceHandler = rh;
		queryBuilder = new SQLiteQueryBuilder();
	}
	
	public SQLiteQueryBuilder getBaseQueryBuilder(){
		return this.queryBuilder;
	}
	
}
