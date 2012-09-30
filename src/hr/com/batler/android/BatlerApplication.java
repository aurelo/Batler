package hr.com.batler.android;

import hr.com.batler.android.resources.ResourceHandler;
import android.app.Application;

public class BatlerApplication extends Application {

	private ResourceHandler resourceHandler;
	
	@Override
	public void onCreate() {
		super.onCreate();
		resourceHandler = new ResourceHandler(this);
	}

	public ResourceHandler getResourceHandler() {
		return resourceHandler;
	}

}
