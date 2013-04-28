package org.sferadev.dummylauncher;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.pm.PackageManager;

public class onResetHome extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

	        PackageManager pm = null;
	        
	        pm.clearPackagePreferredActivities(PACKAGE_NAME);
	        
        
	}
	
}
