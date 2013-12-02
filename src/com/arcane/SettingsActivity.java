package com.arcane;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SettingsActivity extends Activity {
    /** Called when the activity is first created. */
	ImageButton ibHome, ibMenu;
	
	TextView tvProfile, tvSecurity, tvAbtUs,tvHelp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
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
        		
        		Intent i= new Intent(getApplicationContext(),MenuActivity.class);
        		startActivity(i);
        	}
        });
        tvProfile=(TextView)findViewById(R.id.tvProfileset);
        tvProfile.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        		Intent i= new Intent(getApplicationContext(),ProfileSettingsActivity.class);
        		startActivity(i);
        	}
        });
        tvSecurity=(TextView)findViewById(R.id.tvSecuSet);
        tvSecurity.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        		Intent i= new Intent(getApplicationContext(),SecuritySettingsActivity.class);
        		startActivity(i);
        	}
        });
        tvAbtUs=(TextView)findViewById(R.id.tvAboutUs);
        tvAbtUs.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i=new Intent(getApplicationContext(),AboutUsActivity.class);
			startActivity(i);
			}
		});
        tvHelp=(TextView)findViewById(R.id.tvhelp);
        tvHelp.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i=new Intent(getApplicationContext(),HelpActivity.class);
			startActivity(i);
			}
		});
        	}
		
    }
    