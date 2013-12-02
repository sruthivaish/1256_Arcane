package com.arcane;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
public class AboutUsActivity extends Activity {
    /** Called when the activity is first created. */
	ImageButton ibHome, ibMenu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        ibHome=(ImageButton)findViewById(R.id.ibHome);
        ibHome.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        		Intent i= new Intent(getApplicationContext(),HomeActivity.class);
        		startActivity(i);
        	}
        });
        ibMenu=(ImageButton)findViewById(R.id.ibMenu);
        ibMenu.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        		Intent i= new Intent(getApplicationContext(),SettingsActivity.class);
        		startActivity(i);
        	}
        });
    }

}
