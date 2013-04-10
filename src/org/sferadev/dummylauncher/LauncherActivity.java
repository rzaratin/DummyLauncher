package org.sferadev.dummylauncher;

import java.util.List;

import org.sferadev.dummylauncher.AppLauncher.*;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LauncherActivity extends Activity {
	
	ImageButton bBrowser;
	ImageButton bCalendar;
	Runnable runme = null;
	PackageManager pm;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        
        runme = new Runnable(){
			public void run(){
				AppLauncher myActivity = new AppLauncher();
		        myActivity.getApps();
			}
		};
        
        if(isAppInstalled("com.google.android.googlequicksearchbox")){
        	
        }
        else {
        	bBrowser = (ImageButton) findViewById(R.id.bBrowser);
    		bBrowser.setVisibility(View.GONE);
    		
        }
        
        if(isAppInstalled("com.google.android.googlequicksearchb")){
        	
        }
        else {
        	
        }
    }
    
    
    public void onApps(View v){
    	Intent intent = new Intent(this, AppLauncher.class);
        this.startActivity(intent);
    }
    
    
    private boolean isAppInstalled(String uri) {
    	PackageManager pm = getPackageManager();
    	boolean installed = true;
    	try {
    	pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
    	installed = true;
    	} catch (PackageManager.NameNotFoundException e) {
    	installed = false;
    	}
    	return installed;
    	}
    
    public void onGoogle(View v){
    	/*if(isAppInstalled("com.google.android.googlequicksearchbox")){
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
		
    	}*/ 	
    }

    public void onCalendar(View v){
    	if(isAppInstalled("com.google.android.calendar")){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage("com.android.chrome");
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
    	Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage("com.android.calendar");
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);	
    	}
	}
    
	public void onBrowser(View v){
		if(isAppInstalled("com.android.chrome")){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage("com.android.chrome");
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage("com.android.browser");
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
    	}
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
	
	public void onMail(View v){
		if(isAppInstalled("com.google.android.gm")){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage("com.google.android.gm");
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage("com.android.email");
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
    	}
	}
	
	public void onKeep(View v){
    	if(isAppInstalled("com.google.android.keep")){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage("com.google.android.keep");
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
    		Context context = getApplicationContext();
    		CharSequence text = "Google Keep not installed";
    		int duration = Toast.LENGTH_LONG;
    		Toast toast = Toast.makeText(context, text, duration);
    		toast.show();
    		
    		String url = "https://play.google.com/store/apps/details?id=com.google.android.keep";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
    	}
    		    	
    }
    
	public void onMaps(View v){
    	if(isAppInstalled("com.google.android.apps.maps")){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage("com.google.android.apps.maps");
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
    		Context context = getApplicationContext();
    		CharSequence text = "Google Maps not installed";
    		int duration = Toast.LENGTH_LONG;
    		Toast toast = Toast.makeText(context, text, duration);
    		toast.show();
    		
    		String url = "https://play.google.com/store/apps/details?id=com.google.android.apps.maps";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
    	}
    		    	
    }
	
	public void onDrive(View v){
    	if(isAppInstalled("com.google.android.apps.docs")){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage("com.google.android.apps.docs");
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
    		Context context = getApplicationContext();
    		CharSequence text = "Google Drive not installed";
    		int duration = Toast.LENGTH_LONG;
    		Toast toast = Toast.makeText(context, text, duration);
    		toast.show();
    		
    		String url = "https://play.google.com/store/apps/details?id=com.google.android.apps.docs";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
    	}
    		    	
    }
	
	public void onCurrents(View v){
    	if(isAppInstalled("com.google.android.apps.currents")){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage("com.google.android.apps.currents");
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
    		Context context = getApplicationContext();
    		CharSequence text = "Google Drive not installed";
    		int duration = Toast.LENGTH_LONG;
    		Toast toast = Toast.makeText(context, text, duration);
    		toast.show();
    		
    		String url = "https://play.google.com/store/apps/details?id=com.google.android.apps.currents";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
    	}
    		    	
    }
	
	public void onFirefox(View v){
    	if(isAppInstalled("org.mozilla.firefox")){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage("org.mozilla.firefox");
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
    		
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
}
