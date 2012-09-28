package hr.com.batler.android.resources;

import android.content.Context;

public class ResourceHandler {

	private Context context;

	public ResourceHandler(Context context) {
		super();
		this.context = context;
	} 

	public String getErrorMessage(int resourceId, Object... args){
		return String.format(context.getResources().getText(resourceId).toString(), args);
	}
	
	
	
}
