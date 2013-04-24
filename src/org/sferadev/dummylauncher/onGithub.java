package org.sferadev.dummylauncher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class onGithub extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

	        String url = "https://github.com/SferaDev/DummyLauncher/";
	        Intent i = new Intent(Intent.ACTION_VIEW);
	        i.setData(Uri.parse(url));
	        startActivity(i);
        
	}

}
