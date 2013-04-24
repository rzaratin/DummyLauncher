package org.sferadev.dummylauncher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class onXDA extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        github();
        
	}
        
        
        public void github() {
	        String url = "";
	        Intent i = new Intent(Intent.ACTION_VIEW);
	        i.setData(Uri.parse(url));
	        startActivity(i);
        
	}

}
