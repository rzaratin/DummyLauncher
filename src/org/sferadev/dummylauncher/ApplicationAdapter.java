package org.sferadev.dummylauncher;

import java.util.ArrayList;

import org.sferadev.dummylauncher.AppLauncher.AppInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ApplicationAdapter extends ArrayAdapter<AppInfo>{
	private ArrayList<AppInfo> items;

	public ApplicationAdapter(Context context, int textViewResourceId, 
			ArrayList<AppInfo> items){
        super(context, textViewResourceId, items);
        this.items = items;
	}

	
}