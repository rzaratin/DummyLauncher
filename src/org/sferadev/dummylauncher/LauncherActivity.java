package org.sferadev.dummylauncher;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    private boolean isAppInstalled(String uri) {
    	PackageManager pm = getPackageManager();
    	boolean installed = false;
    	try {
    	pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
    	installed = true;
    	} catch (PackageManager.NameNotFoundException e) {
    	installed = false;
    	}
    	return installed;
    	}
    
    public void onGoogle(View v){
    	if(isAppInstalled("com.google.android.googlequicksearchbox")){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage("com.google.android.googlequicksearchbox");
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
    		Context context = getApplicationContext();
    		CharSequence text = "Google Search not installed";
    		int duration = Toast.LENGTH_LONG;

    		Toast toast = Toast.makeText(context, text, duration);
    		toast.show();
    		String url = "https://play.google.com/store/apps/details?id=com.google.android.googlequicksearchbox";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
    	}
    		    	
    }

    public void onCalendar(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage("com.android.calendar");
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);	
	}
    
	public void onBrowser(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage("com.android.browser");
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
	}

	public void onContacts(View v){
		Intent i = new Intent(Intent.ACTION_MAIN);
		i.setComponent(new ComponentName("com.android.contacts","com.android.contacts.activities.PeopleActivity"));
		startActivity(i);
	}

	public void onPhone(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage("com.android.contacts");
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
	}
    
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.launcher, menu);
        return true;
    }
    */
}
