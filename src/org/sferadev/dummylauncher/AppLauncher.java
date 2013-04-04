package org.sferadev.dummylauncher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
 
public class AppLauncher extends ListActivity{
	ApplicationAdapter appAdapter = null;
	ProgressDialog progressDialog = null; 
	static Runnable viewApps = null;
	ArrayList<AppInfo> packageList = null;
	Applications myApps = null;
 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
 
		this.setContentView(R.layout.applauncher);
 
		packageList = new ArrayList<AppInfo>();
		appAdapter = new ApplicationAdapter(this, R.layout.applauncherrow,
				packageList);
 
		this.setListAdapter(appAdapter);
 
		viewApps = new Runnable(){
			public void run(){
				getApps();
			}
		};
 
		Thread appLoaderThread = new Thread(null, viewApps, 
				"AppLoaderThread");
		appLoaderThread.start();
 
		//progressDialog = ProgressDialog.show(AppLauncher.this, 
				//"Hold on...", "Loading your apps...", true);
	}
 
	public class Applications{
		private ArrayList<AppInfo> packageList = null;
		private List<ResolveInfo> activityList = null;
		private Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		private PackageManager packMan = null;
 
		public Applications(PackageManager packManager){
			packMan = packManager;
			packageList = this.createPackageList(false);
			activityList = this.createActivityList();
			this.addClassNamesToPackageList();
		}
 
		public ArrayList<AppInfo> getPackageList(){
			return packageList;
		}
 
		public List<ResolveInfo> getActivityList(){
			return activityList;
		}
 
		private ArrayList<AppInfo> createPackageList(boolean getSysPackages){
			ArrayList<AppInfo> pList = new ArrayList<AppInfo>();        
 
		    List<PackageInfo> packs = getPackageManager(
		    		).getInstalledPackages(0);
 
		    for(int i = 0; i < packs.size(); i++){
		        PackageInfo packInfo = packs.get(i);
 
		        if((!getSysPackages) && (packInfo.versionName == null)){
		            continue ;
		        }
 
		        AppInfo newInfo = new AppInfo();
 
		        newInfo.appName = packInfo.applicationInfo.loadLabel(
		        		getPackageManager()).toString();
		        newInfo.packageName = packInfo.packageName;   
		        newInfo.versionName = packInfo.versionName;
		        newInfo.versionCode = packInfo.versionCode;
		        newInfo.icon = packInfo.applicationInfo.loadIcon(
		        		getPackageManager());
 
		        pList.add(newInfo);
		    }
		    return pList; 
		}
 
		private List<ResolveInfo> createActivityList(){
			List<ResolveInfo> aList = packMan.queryIntentActivities(mainIntent, 0);
 
			Collections.sort(aList, 
					new ResolveInfo.DisplayNameComparator(packMan)); 
 
			return aList;
		}
 
		private void packageDebug(){
			if(null == packageList){
				return;
			}
 
			for(int i = 0; i < packageList.size(); ++i){
				Log.v("PACKINFO: ", "\t" + 
						packageList.get(i).appName + "\t" + 
						packageList.get(i).packageName + "\t" + 
						packageList.get(i).className + "\t" +
						packageList.get(i).versionName + "\t" + 
						packageList.get(i).versionCode);
			}
		}
 
		private void activityDebug(){
			if(null == activityList){
				return;
			}
 
			for(int i = 0; i < activityList.size(); i++){ 
				ActivityInfo currentActivity = activityList.get(
						i).activityInfo;
				Log.v("ACTINFO", 
						"pName=" 
						+ currentActivity.applicationInfo.packageName +
						" cName=" + currentActivity.name);
			}
		}
 
		private void addClassNamesToPackageList(){
			if(null == activityList || null == packageList){
				return;
			}
 
			String tempName = "";
 
			for(int i = 0; i < packageList.size(); ++i){
				tempName = packageList.get(i).packageName;
 
				for(int j = 0; j < activityList.size(); ++j){
					if(tempName.equals(activityList.get(
							j).activityInfo.applicationInfo.packageName)){
						packageList.get(i).className = activityList.get(
								j).activityInfo.name;
					}
				}
			}
		}
	}
 
	public class AppInfo{
		private String appName = "";
		private String packageName = "";
		private String className = "";
		private String versionName = "";
		private Integer versionCode = 0;
		private Drawable icon = null;
 
		public String getAppName(){
			return appName;
		}
 
		public String getPackageName(){
			return packageName;
		}
 
		public String getClassName(){
			return className;
		}
 
		public String getVersionName(){
			return versionName;
		}
 
		public Integer getVersionCode(){
			return versionCode;
		}
 
		public Drawable getIcon(){
			return icon;
		}
	}
 
	public class ApplicationAdapter extends ArrayAdapter<AppInfo>{
		private ArrayList<AppInfo> items;
 
		public ApplicationAdapter(Context context, int textViewResourceId, 
				ArrayList<AppInfo> items){
            super(context, textViewResourceId, items);
            this.items = items;
		}
 
		@Override
        public View getView(int position, View convertView, 
        		ViewGroup parent){
			View view = convertView;
 
			if(view == null){
				LayoutInflater layout = (LayoutInflater)getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
				view = layout.inflate(R.layout.applauncherrow, null);
			}
 
			AppInfo appInfo = items.get(position);
			if(appInfo != null){
				TextView appName = (TextView) view.findViewById(
						R.id.applauncherrow_appname);
				ImageView appIcon = (ImageView) view.findViewById(
						R.id.applauncherrow_icon);
 
				if(appName != null){
					appName.setText(appInfo.getAppName());
				}
				if(appIcon != null){
					appIcon.setImageDrawable(appInfo.getIcon());
				}
			}
 
			return view;
		}
	}
 
	public void getApps(){
		try{
			myApps = new Applications(getPackageManager());
			packageList = myApps.getPackageList();
		}
		catch(Exception exception){
			Log.e("BACKGROUND PROC:", exception.getMessage());
		}
		this.runOnUiThread(returnRes);
	}
 
	private Runnable returnRes = new Runnable(){
		public void run(){
			if(packageList != null && packageList.size() > 0){
				appAdapter.notifyDataSetChanged();
 
				for(int i = 0; i < packageList.size(); ++i){
					appAdapter.add(packageList.get(i));
				}
			}
			//progressDialog.dismiss();
			appAdapter.notifyDataSetChanged();
		}
	};
 
	@Override
	protected void onListItemClick(ListView list, View view, int position, 
			long id){
		super.onListItemClick(list, view, position, id);
 
		AppInfo rowClicked = (AppInfo)this.getListAdapter().getItem(
				position);
 
		Intent startApp = new Intent();
		ComponentName component = new ComponentName(
				rowClicked.getPackageName(), 
				rowClicked.getClassName());
		startApp.setComponent(component);
		startApp.setAction(Intent.ACTION_MAIN);
 
		startActivity(startApp);
	}
}