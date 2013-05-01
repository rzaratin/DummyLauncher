package org.sferadev.dummylauncher;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;
import android.content.pm.PackageManager;

public class onResetHome extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
        	PackageManager pm = getPackageManager();
            pm.clearPackagePreferredActivities("org.sferadev.dummylauncher");
        
            Context context = getApplicationContext();
    		CharSequence text = "Done";
    		int duration = Toast.LENGTH_SHORT;
    		Toast toast = Toast.makeText(context, text, duration);
    		toast.show();
        }
        catch (Exception e) {
			
    		}
	        
        
	}
	
}
