package hr.com.batler.android.contentprovider;

import hr.com.batler.android.model.tables.Queryable;
import hr.com.batler.android.model.tables.TagTable;

import java.util.HashMap;
import java.util.Map;

class TableNameClassNameMapper {

	protected static Map<String, Class<? extends Queryable>> mapper = new HashMap<String, Class<? extends Queryable>>();

	static {
		mapper.put(TagTable.TABLE_TAGS, TagTable.class);
	}

}
