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
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LauncherActivity extends Activity {
	
	Runnable runme = null;
	PackageManager pm;
	
	Button bSearch;
	ImageButton bPhone;
	ImageButton bContacts;
	ImageButton bBrowser;
	ImageButton bCalendar;
	ImageButton bGmail;
	ImageButton bKeep;
	ImageButton bMaps;
	ImageButton bDrive;
	ImageButton bCurrents;
	ImageButton bPlay;
	ImageButton bWhatsApp;
	ImageButton bLine;
	ImageButton bSkype;
	ImageButton bViber;
	ImageButton bFacebook;
	ImageButton bTwitter;
	ImageButton bTuenti;
	ImageButton bInstagram;
	ImageButton bTapatalk;
	
	String sSearch = "com.google.android.googlequicksearchbox";
	String sFirefox = "org.mozilla.firefox";
	String sCurrents = "com.google.android.apps.currents";
	String sDrive = "com.google.android.apps.docs";
	String sMaps = "com.google.android.apps.maps";
	String sKeep = "com.google.android.keep";
	String sGmail = "com.google.android.gm";
	String sPlay = "com.android.vending";
	String sPhone = "com.android.contacts";
	String sContacts = "com.android.contacts.activities.PeopleActivity";
	String sBrowser = "com.android.browser";
	String sChrome = "com.android.chrome";
	String sGCalendar = "com.google.android.calendar";
	String sCalendar = "com.android.calendar";
	String sWhatsApp = "com.whatsapp";
	String sLine = "jp.naver.line.android";
	String sSkype = "com.skype.raider";
	String sViber = "com.viber.voip";
	String sFacebook = "com.facebook.katana";
	String sTwitter = "com.twitter.android";
	String sTuenti = "com.tuenti.android.client";
	String sInstagram = "com.instagram.android";
	String sTapatalk = "com.quoord.tapatalkpro.activity";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        
        getIcons();
        
        hideNotInstalledApps();
    }
    
    public void hideNotInstalledApps(){
    	// Hide new items if they are not installed
        
    	bSearch = (Button) findViewById(R.id.bSearch);
    	bGmail = (ImageButton) findViewById(R.id.bGmail);
    	bKeep = (ImageButton) findViewById(R.id.bKeep);
    	bMaps = (ImageButton) findViewById(R.id.bMaps);
    	bDrive = (ImageButton) findViewById(R.id.bDrive);
    	bCurrents = (ImageButton) findViewById(R.id.bCurrents);
    	bPlay = (ImageButton) findViewById(R.id.bPlay);
    	bWhatsApp = (ImageButton) findViewById(R.id.bWhatsApp);
    	bLine = (ImageButton) findViewById(R.id.bLine);
    	bSkype = (ImageButton) findViewById(R.id.bSkype);
    	bViber = (ImageButton) findViewById(R.id.bViber);
    	bFacebook = (ImageButton) findViewById(R.id.bFacebook);
    	bTwitter = (ImageButton) findViewById(R.id.bTwitter);
    	bInstagram = (ImageButton) findViewById(R.id.bInstagram);
    	bTuenti = (ImageButton) findViewById(R.id.bTuenti);
    	bTapatalk = (ImageButton) findViewById(R.id.bTapatalk);
    	    	
    	if(isNotAppInstalled(sSearch)){
    		bSearch.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sGmail)){
    		bGmail.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sKeep)){
    		bKeep.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sMaps)){
    		bMaps.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sDrive)){
    		bDrive.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sCurrents)){
    		bCurrents.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sPlay)){
    		bPlay.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sWhatsApp)){
    		bWhatsApp.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sLine)){
    		bLine.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sSkype)){
    		bSkype.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sViber)){
    		bViber.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sFacebook)){
    		bFacebook.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sTwitter)){
    		bTwitter.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sTuenti)){
    		bTuenti.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sInstagram)){
    		bInstagram.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sTapatalk)){
    		bTapatalk.setVisibility(View.GONE);
        }
    }
    
    public void getIcons(){
    	try{
    		Drawable iBrowser;
    		iBrowser = getBaseContext().getPackageManager().getApplicationIcon(sBrowser);    		
    		bBrowser = (ImageButton) findViewById(R.id.bBrowser);
    		bBrowser.setImageDrawable(iBrowser);
		}
		catch (PackageManager.NameNotFoundException ne)
			{

			}
		
    	try{
    		Drawable iCalendar;
    		iCalendar = getBaseContext().getPackageManager().getApplicationIcon(sCalendar);    		
    		bCalendar = (ImageButton) findViewById(R.id.bCalendar);
    		bCalendar.setImageDrawable(iCalendar);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iGmail;
    		iGmail = getBaseContext().getPackageManager().getApplicationIcon(sGmail);    		
    		bGmail = (ImageButton) findViewById(R.id.bGmail);
    		bGmail.setImageDrawable(iGmail);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iKeep;
    		iKeep = getBaseContext().getPackageManager().getApplicationIcon(sKeep);    		
    		bKeep = (ImageButton) findViewById(R.id.bKeep);
    		bKeep.setImageDrawable(iKeep);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iMaps;
    		iMaps = getBaseContext().getPackageManager().getApplicationIcon(sMaps);    		
    		bMaps = (ImageButton) findViewById(R.id.bMaps);
    		bMaps.setImageDrawable(iMaps);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iDrive;
    		iDrive = getBaseContext().getPackageManager().getApplicationIcon(sDrive);    		
    		bDrive = (ImageButton) findViewById(R.id.bDrive);
    		bDrive.setImageDrawable(iDrive);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iCurrents;
    		iCurrents = getBaseContext().getPackageManager().getApplicationIcon(sCurrents);    		
    		bCurrents = (ImageButton) findViewById(R.id.bCurrents);
    		bCurrents.setImageDrawable(iCurrents);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iPlay;
    		iPlay = getBaseContext().getPackageManager().getApplicationIcon(sPlay);    		
    		bPlay = (ImageButton) findViewById(R.id.bPlay);
    		bPlay.setImageDrawable(iPlay);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iWhatsApp;
    		iWhatsApp = getBaseContext().getPackageManager().getApplicationIcon(sWhatsApp);    		
    		bWhatsApp = (ImageButton) findViewById(R.id.bWhatsApp);
    		bWhatsApp.setImageDrawable(iWhatsApp);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iLine;
    		iLine = getBaseContext().getPackageManager().getApplicationIcon(sLine);    		
    		bLine = (ImageButton) findViewById(R.id.bLine);
    		bLine.setImageDrawable(iLine);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iSkype;
    		iSkype = getBaseContext().getPackageManager().getApplicationIcon(sSkype);    		
    		bSkype = (ImageButton) findViewById(R.id.bSkype);
    		bSkype.setImageDrawable(iSkype);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iViber;
    		iViber = getBaseContext().getPackageManager().getApplicationIcon(sViber);    		
    		bViber = (ImageButton) findViewById(R.id.bViber);
    		bViber.setImageDrawable(iViber);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iFacebook;
    		iFacebook = getBaseContext().getPackageManager().getApplicationIcon(sFacebook);    		
    		bFacebook = (ImageButton) findViewById(R.id.bFacebook);
    		bFacebook.setImageDrawable(iFacebook);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iTwitter;
    		iTwitter = getBaseContext().getPackageManager().getApplicationIcon(sTwitter);    		
    		bTwitter = (ImageButton) findViewById(R.id.bTwitter);
    		bTwitter.setImageDrawable(iTwitter);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iTuenti;
    		iTuenti = getBaseContext().getPackageManager().getApplicationIcon(sTuenti);    		
    		bTuenti = (ImageButton) findViewById(R.id.bTuenti);
    		bTuenti.setImageDrawable(iTuenti);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iInstagram;
    		iInstagram = getBaseContext().getPackageManager().getApplicationIcon(sInstagram);    		
    		bInstagram = (ImageButton) findViewById(R.id.bInstagram);
    		bInstagram.setImageDrawable(iInstagram);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iTapatalk;
    		iTapatalk = getBaseContext().getPackageManager().getApplicationIcon(sTapatalk);    		
    		bTapatalk = (ImageButton) findViewById(R.id.bTapatalk);
    		bTapatalk.setImageDrawable(iTapatalk);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    }
    
    public void onApps(View v){
    	Intent intent = new Intent(this, AppLauncher.class);
        this.startActivity(intent);
    }
    
    public void onAbout(View v){
    	Intent intent = new Intent(this, AboutActivity.class);
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
    
    private boolean isNotAppInstalled(String uri) {
    	PackageManager pm = getPackageManager();
    	boolean installed = true;
    	try {
    	pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
    	installed = false;
    	} catch (PackageManager.NameNotFoundException e) {
    	installed = true;
    	}
    	return installed;
    	}
    
    public void onGoogle(View v){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage(sSearch);
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    	    }

    public void onCalendar(View v){
    		if(isAppInstalled(sGCalendar)){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage(sGCalendar);
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
    	Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sCalendar);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);	
    	}
   	}
    
	public void onBrowser(View v){
			if(isAppInstalled(sChrome)){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage(sChrome);
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    	else{
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sBrowser);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
    	}
	}

	public void onContacts(View v){
			Intent i = new Intent(Intent.ACTION_MAIN);
			i.setComponent(new ComponentName(sPhone, sContacts));
			startActivity(i);
			}

	public void onPhone(View v){
			Intent i = new Intent();
			PackageManager manager = getPackageManager();
			i = manager.getLaunchIntentForPackage(sPhone);
			i.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(i);
			}
	
	public void onMail(View v){
			Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage(sGmail);
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
			}
	
	public void onKeep(View v){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage(sKeep);
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
    
	public void onMaps(View v){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage(sMaps);
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
	
	public void onDrive(View v){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage(sDrive);
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
	
	public void onCurrents(View v){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage(sCurrents);
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    }
	
	public void onFirefox(View v){
    		Intent i = new Intent();
    		PackageManager manager = getPackageManager();
    		i = manager.getLaunchIntentForPackage(sFirefox);
    		i.addCategory(Intent.CATEGORY_LAUNCHER);
    		startActivity(i);
    		}
	
	public void onPlay(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sPlay);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onWhatsApp(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sWhatsApp);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onLine(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sLine);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onSkype(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sSkype);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onViber(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sViber);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onFacebook(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sFacebook);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onTwitter(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sTwitter);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onTuenti(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sTuenti);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onInstagram(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sInstagram);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onTapatalk(View v){
		Intent i = new Intent(Intent.ACTION_MAIN);
		i.setComponent(new ComponentName(sTapatalk, "com.quoord.tapatalkpro.activity.directory.EntryActivity"));
		startActivity(i);
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.launcher, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case R.id.about:
                onAbout(null);
                return true;
   		}
        
        return false;
    }
    
}
