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
	ImageButton bTriviados;
	ImageButton bPou;
	ImageButton bCut1;
	ImageButton bFloor;
	ImageButton bApalabrados;
	ImageButton bAngry;
	ImageButton bBike;
	ImageButton bIron;
	ImageButton bTemple1;
	ImageButton bTemple2;
	ImageButton bAngrySW;
	ImageButton bMinecraft;
	ImageButton bAngryRio;
	ImageButton bDraw;
	ImageButton bWordCrack;
	ImageButton bIngress;
	
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
	String sTriviados = "aul.irm.triviados";
	String sPou = "me.pou.app";
	String sCut1 = "com.zeptolab.timetravel.free.google";
	String sFloor = "cento.n2.lib";
	String sApalabrados = "com.etermax.apalabrados.lite";
	String sAngry = "com.rovio.angrybirds";
	String sBike = "com.topfreegames.bikeracefreeworld";
	String sIron = "com.gameloft.android.ANMP.GloftIMHM";
	String sTemple1 = "com.imangi.templerun";
	String sTemple2 = "com.imangi.templerun2";
	String sAngrySW = "com.rovio.angrybirdsstarwars.ads.iap";
	String sMinecraft = "com.mojang.minecraftpe.demo";
	String sAngryRio = "com.rovio.angrybirdsrio";
	String sDraw = "com.omgpop.dstfree";
	String sWordCrack = "com.etermax.wordcrack.lite";
	String sIngress = "com.nianticproject.ingress";

	
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
    	
    	bTriviados = (ImageButton) findViewById(R.id.bTriviados);
    	bPou = (ImageButton) findViewById(R.id.bPou);
    	bCut1 = (ImageButton) findViewById(R.id.bCut1);
    	bFloor = (ImageButton) findViewById(R.id.bFloor);
    	bApalabrados = (ImageButton) findViewById(R.id.bApalabrados);
    	bAngry = (ImageButton) findViewById(R.id.bAngry);
    	bAngrySW = (ImageButton) findViewById(R.id.bAngrySW);
    	bAngryRio = (ImageButton) findViewById(R.id.bAngryRio);
    	bBike = (ImageButton) findViewById(R.id.bBike);
    	bIron = (ImageButton) findViewById(R.id.bIron);
    	bTemple1 = (ImageButton) findViewById(R.id.bTemple1);
    	bTemple2 = (ImageButton) findViewById(R.id.bTemple2);
    	bMinecraft = (ImageButton) findViewById(R.id.bMinecraft);
    	bDraw = (ImageButton) findViewById(R.id.bDraw);
    	bWordCrack = (ImageButton) findViewById(R.id.bWordCrack);
    	bIngress = (ImageButton) findViewById(R.id.bIngress);    	
    	
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
    	if(isNotAppInstalled(sTriviados)){
    		bTriviados.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sPou)){
    		bPou.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sCut1)){
    		bCut1.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sFloor)){
    		bFloor.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sApalabrados)){
    		bApalabrados.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sAngry)){
    		bAngry.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sAngrySW)){
    		bAngrySW.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sAngryRio)){
    		bAngryRio.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sBike)){
    		bBike.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sIron)){
    		bIron.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sTemple1)){
    		bTemple1.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sTemple2)){
    		bTemple2.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sMinecraft)){
    		bMinecraft.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sDraw)){
    		bDraw.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sWordCrack)){
    		bWordCrack.setVisibility(View.GONE);
        }
    	if(isNotAppInstalled(sIngress)){
    		bIngress.setVisibility(View.GONE);
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
    	
    	try{
    		Drawable iTriviados;
    		iTriviados = getBaseContext().getPackageManager().getApplicationIcon(sTriviados);    		
    		bTriviados = (ImageButton) findViewById(R.id.bTriviados);
    		bTriviados.setImageDrawable(iTriviados);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iPou;
    		iPou = getBaseContext().getPackageManager().getApplicationIcon(sPou);    		
    		bPou = (ImageButton) findViewById(R.id.bPou);
    		bPou.setImageDrawable(iPou);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iCut1;
    		iCut1 = getBaseContext().getPackageManager().getApplicationIcon(sCut1);    		
    		bCut1 = (ImageButton) findViewById(R.id.bCut1);
    		bCut1.setImageDrawable(iCut1);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iFloor;
    		iFloor = getBaseContext().getPackageManager().getApplicationIcon(sFloor);    		
    		bFloor = (ImageButton) findViewById(R.id.bFloor);
    		bFloor.setImageDrawable(iFloor);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iApalabrados;
    		iApalabrados = getBaseContext().getPackageManager().getApplicationIcon(sApalabrados);    		
    		bApalabrados = (ImageButton) findViewById(R.id.bApalabrados);
    		bApalabrados.setImageDrawable(iApalabrados);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iAngry;
    		iAngry = getBaseContext().getPackageManager().getApplicationIcon(sAngry);    		
    		bAngry = (ImageButton) findViewById(R.id.bAngry);
    		bAngry.setImageDrawable(iAngry);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iAngrySW;
    		iAngrySW = getBaseContext().getPackageManager().getApplicationIcon(sAngrySW);    		
    		bAngrySW = (ImageButton) findViewById(R.id.bAngrySW);
    		bAngrySW.setImageDrawable(iAngrySW);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iAngryRio;
    		iAngryRio = getBaseContext().getPackageManager().getApplicationIcon(sAngryRio);    		
    		bAngryRio = (ImageButton) findViewById(R.id.bAngryRio);
    		bAngryRio.setImageDrawable(iAngryRio);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iBike;
    		iBike = getBaseContext().getPackageManager().getApplicationIcon(sBike);    		
    		bBike = (ImageButton) findViewById(R.id.bBike);
    		bBike.setImageDrawable(iBike);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iIron;
    		iIron = getBaseContext().getPackageManager().getApplicationIcon(sIron);    		
    		bIron = (ImageButton) findViewById(R.id.bIron);
    		bIron.setImageDrawable(iIron);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iTemple1;
    		iTemple1 = getBaseContext().getPackageManager().getApplicationIcon(sTemple1);    		
    		bTemple1 = (ImageButton) findViewById(R.id.bTemple1);
    		bTemple1.setImageDrawable(iTemple1);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iTemple2;
    		iTemple2 = getBaseContext().getPackageManager().getApplicationIcon(sTemple2);    		
    		bTemple2 = (ImageButton) findViewById(R.id.bTemple2);
    		bTemple2.setImageDrawable(iTemple2);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iMinecraft;
    		iMinecraft = getBaseContext().getPackageManager().getApplicationIcon(sMinecraft);    		
    		bMinecraft = (ImageButton) findViewById(R.id.bMinecraft);
    		bMinecraft.setImageDrawable(iMinecraft);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iDraw;
    		iDraw = getBaseContext().getPackageManager().getApplicationIcon(sDraw);    		
    		bDraw = (ImageButton) findViewById(R.id.bDraw);
    		bDraw.setImageDrawable(iDraw);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iWordCrack;
    		iWordCrack = getBaseContext().getPackageManager().getApplicationIcon(sWordCrack);    		
    		bWordCrack = (ImageButton) findViewById(R.id.bWordCrack);
    		bWordCrack.setImageDrawable(iWordCrack);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    	
    	try{
    		Drawable iIngress;
    		iIngress = getBaseContext().getPackageManager().getApplicationIcon(sIngress);    		
    		bIngress = (ImageButton) findViewById(R.id.bIngress);
    		bIngress.setImageDrawable(iIngress);
    		}
    		catch (PackageManager.NameNotFoundException ne)
    		 {
    	
    		 }
    }
    
    public void onApps(View v){
    	try {
    		Intent intent = new Intent(this, AppLauncher.class);
    		this.startActivity(intent);
    	}
    	catch (Exception e) {
    		Context context = getApplicationContext();
    		int duration = Toast.LENGTH_SHORT;
    		Toast toast = Toast.makeText(context, R.string.error_launch_app, duration);
    		toast.show();
    	}
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
			try {
				try{
				Intent i = new Intent(Intent.ACTION_MAIN);
				i.setComponent(new ComponentName(sPhone, sContacts));
				startActivity(i);
			}
			catch (Exception e){
				Intent i = new Intent(Intent.ACTION_MAIN);
				i.setComponent(new ComponentName(sPhone, "com.android.contacts.ContactsListActivity"));
				startActivity(i);
			}
			}
			catch (Exception e){
				Context context = getApplicationContext();
	    		int duration = Toast.LENGTH_SHORT;
	    		Toast toast = Toast.makeText(context, R.string.error_launch_app, duration);
	    		toast.show();
			}
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
	
	public void onTriviados(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sTriviados);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onPou(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sPou);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onCut1(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sCut1);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onFloor(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sFloor);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onApalabrados(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sApalabrados);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onAngry(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sAngry);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onAngrySW(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sAngrySW);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onAngryRio(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sAngryRio);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onBike(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sBike);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onIron(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sIron);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onTemple1(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sTemple1);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onTemple2(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sTemple2);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onMinecraft(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sMinecraft);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onDraw(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sDraw);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onWordCrack(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sWordCrack);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
		startActivity(i);
		}
	
	public void onIngress(View v){
		Intent i = new Intent();
		PackageManager manager = getPackageManager();
		i = manager.getLaunchIntentForPackage(sIngress);
		i.addCategory(Intent.CATEGORY_LAUNCHER);
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
