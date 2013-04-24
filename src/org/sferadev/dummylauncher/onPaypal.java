package org.sferadev.dummylauncher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class onPaypal extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

	        String url = "http://forum.xda-developers.com/donatetome.php?u=4710474";
	        Intent i = new Intent(Intent.ACTION_VIEW);
	        i.setData(Uri.parse(url));
	        startActivity(i);
        
	}

}
