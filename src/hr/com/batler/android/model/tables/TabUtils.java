package hr.com.batler.android.model.tables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TabUtils {

	public static boolean projectionContainsValidColumns(String[] projection,
			String[] available) {

		Set<String> projectedColumns = new HashSet<String>(
				Arrays.asList(projection));
		Set<String> availableColumns = new HashSet<String>(
				Arrays.asList(available));
		return availableColumns.containsAll(projectedColumns);
	}

}
