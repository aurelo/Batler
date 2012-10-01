package hr.com.batler.android.contentprovider;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
/**
 * The contract between batler content provider and applications. Contains definitions for supported URI's and columns.
 * <p>
 * <strong>Overview</strong>
 * BatlerContract defines database of batler tasks related database information.  
 * 
 * @author      Zlatko Gudasiæ
 * @version     1, 2012-08-29
 * */
public final class BatlerContract {

	public static final String FORWARDSLASH = "/";
	
	// the scheme part of the provider's URI
	private static final String SCHEME = "content://";
	
	
	/**
	 * AUTHORITY     the authoritiy of the contact provider
	 * */
	public  static final String AUTHORITY = "hr.com.batler.android.contentprovider";
	/**
	 * AUTHORITY_URI a content:// style uri to the authority for the contacts provider    
	 * */
	public  static final Uri AUTHORITY_URI = Uri.parse(SCHEME + AUTHORITY);

	
	/**
	 * TAG defines descriptive keyword that can be applied to other entities, such as tasks, location or templates 
	 * 
	 * @author      Zlatko Gudasiæ
	 * @version     1, 2012-08-29
	 * */
	public static final class Tag {
		
		/**
		 * BASE_PATH     base path for tags table on batler contact provider
		 * */
		public static final String BASE_PATH = "tags";
		/**
		 * CONTENT_URI   a content:// style uri to the authority for the tags table
		 * */
		public static final Uri CONTENT_URI = Uri.parse(SCHEME+AUTHORITY+FORWARDSLASH+BASE_PATH);
		
		
        /*
         * MIME type definitions for Tags
         */

        /**
         * The MIME type of {@link #CONTENT_URI} providing a directory of tags.
         */
		public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
        /**
         * The MIME type of a {@link #CONTENT_URI} sub-directory of a single tag.
         */
		public static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		
		
		public interface TagColumns {
	        /**
	         * projection of all Tags columns
	         */
			public static final String[] ALL_COLUMNS = new String[] {
					BaseColumns._ID, DescColumns.NAME,
					DescColumns.DESCRIPTION, WhenColumns.CREATION_DATE, WhenColumns.LAST_UPDATE_DATE };
		}
	}
	
	/**
	 * Location defines geo physical location determined by latitude and longitude 
	 * 
	 * @author      Zlatko Gudasiæ
	 * @version     1, 2012-10-01
	 * */
	public static final class Location{
		/**
		 * BASE_PATH     base path for locations table on batler contact provider
		 * */
		public static final String BASE_PATH = "locations";
		/**
		 * CONTENT_URI   a content:// style uri to the authority for the locations table
		 * */
		public static final Uri CONTENT_URI = Uri.parse(SCHEME+AUTHORITY+FORWARDSLASH+BASE_PATH);
		
		
        /*
         * MIME type definitions for Locations
         */

        /**
         * The MIME type of {@link #CONTENT_URI} providing a directory of tags.
         */
		public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
        /**
         * The MIME type of a {@link #CONTENT_URI} sub-directory of a single tag.
         */
		public static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		
		
		public interface LocationColumns{
			
			public static final String LATITUDE = "latitude";
			public static final String LONGITUDE = "longitude";
			
	        /**
	         * projection of all Locations columns
	         */
			public static final String[] ALL_COLUMNS = new String[] {
				BaseColumns._ID, DescColumns.NAME,
				DescColumns.DESCRIPTION, LATITUDE, LONGITUDE,
				WhenColumns.CREATION_DATE, WhenColumns.LAST_UPDATE_DATE };
		}
	}
	/*
	 * END of Location definition
	 * */
	
	
	public static final class Template {
		public static final String BASE_PATH = "templates";
		public static final Uri CONTENT_URI = Uri.parse(SCHEME+AUTHORITY+FORWARDSLASH+BASE_PATH);
		public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		public static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		
		public interface TemplateColumns{
	        /**
	         * projection of all Templates columns
	         */
			public static final String[] ALL_COLUMNS = new String[] {
				BaseColumns._ID, DescColumns.NAME,
				DescColumns.DESCRIPTION, WhenColumns.CREATION_DATE, WhenColumns.LAST_UPDATE_DATE };
		}
	}
	
	
	public static final class Perspective {
		public static final String BASE_PATH = "perspectives";
		public static final Uri CONTENT_URI = Uri.parse(SCHEME+AUTHORITY+FORWARDSLASH+BASE_PATH);
		public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		public static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		
		public interface ContextColumns{
	        /**
	         * projection of all Templates columns
	         */
			public static final String[] ALL_COLUMNS = new String[] {
				BaseColumns._ID, DescColumns.NAME,
				DescColumns.DESCRIPTION, WhenColumns.CREATION_DATE, WhenColumns.LAST_UPDATE_DATE };
		}
	}
	
	public static final class Task {
		public static final String BASE_PATH = "tasks";
		public static final Uri CONTENT_URI = Uri.parse(SCHEME+AUTHORITY+FORWARDSLASH+BASE_PATH);
		public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		public static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		
		public interface TaskColumns{
			public static final String URGENCY = "urgency";
			public static final String IMPORTANCE = "importance";
			public static final String START_DATE = "start_date";
			public static final String END_DATE = "end_date";
			
			public static final String[] ALL_COLUMNS = new String[] {
				BaseColumns._ID, DescColumns.NAME,
				DescColumns.DESCRIPTION, URGENCY, IMPORTANCE, START_DATE, END_DATE, WhenColumns.CREATION_DATE, WhenColumns.LAST_UPDATE_DATE };
		}
    }
	
	public static final class Colaborator{
		public static final String BASE_PATH = "persons";
		public static final Uri CONTENT_URI = Uri.parse(SCHEME+AUTHORITY+FORWARDSLASH+BASE_PATH);
		public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		public static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;

		public interface ColaboratorColumns{
			public static final String CONTACT_URI = "contact_uri";
			public static final String CONTACT_GROUP_URI = "contact_group_uri";
			
			public static final String [] ALL_COLUMNS = new String []{
				BaseColumns._ID, CONTACT_URI, CONTACT_GROUP_URI
			};
		}
		
	}
	
	/**
	 * Standard names for foreign keys (FK) columns for primary tables primary keys (PK's) 
	 * <p>
	 * Intersection tables between base tables have foreign key columns  
	 * 
	 * @author      Zlatko Gudasiæ
	 * @version     1, 2012-08-29
	 * */
	public interface FkColumns {
		public static final String TASK_ID = "taks_id";
		public static final String TAG_ID = "tag_id";
		public static final String LOCATION_ID = "location_id";
		public static final String COLABORATOR_ID = "colaborator_id";
		public static final String PERSPECTIVE_ID = "perspective_id";
		
	}
		
    public static final class TaskTag {
    	public static final String BASE_PATH = "tasksTags";
		public static final Uri CONTENT_URI = Uri.parse(SCHEME+AUTHORITY+FORWARDSLASH+BASE_PATH);
		public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		public static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;

		public interface TaskTagColumns{
			
			public static final String [] ALL_COLUMNS = new String []{
				BaseColumns._ID, FkColumns.TASK_ID, FkColumns.TAG_ID ,WhenColumns.CREATION_DATE, WhenColumns.LAST_UPDATE_DATE
			};
		}
    }
		
	public static final class TaskLocation {
    	public static final String BASE_PATH = "tasksLocations";
		public static final Uri CONTENT_URI = Uri.parse(SCHEME+AUTHORITY+FORWARDSLASH+BASE_PATH);
		public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		public static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;

		
		public interface TaskLocationColumns{
			public static final String [] ALL_COLUMNS = new String []{
				BaseColumns._ID, FkColumns.TASK_ID, FkColumns.LOCATION_ID ,WhenColumns.CREATION_DATE, WhenColumns.LAST_UPDATE_DATE
			};
		}
		
	}
	
	public static final class TaskColaborator {
    	public static final String BASE_PATH = "tasksPersons";
    	public static final Uri CONTENT_URI = Uri.parse(SCHEME+AUTHORITY+FORWARDSLASH+BASE_PATH);
		public static String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;
		public static String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + FORWARDSLASH + AUTHORITY + FORWARDSLASH + BASE_PATH;

		
		public interface TaskColaboratorColumns{
			public static final String [] ALL_COLUMNS = new String []{
				BaseColumns._ID, FkColumns.TASK_ID, FkColumns.COLABORATOR_ID, WhenColumns.CREATION_DATE, WhenColumns.LAST_UPDATE_DATE
			};
		}
	}
		

}
