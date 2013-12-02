package com.arcane;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MenuActivity extends Activity {
    /** Called when the activity is first created. */
	ImageButton ibHome, ibMenu;
	TextView tvCreate, tvView, tvSettings, tvExit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        ibHome=(ImageButton)findViewById(R.id.ibHome);
        ibHome.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        		Intent i= new Intent(getApplicationContext(),HomeActivity.class);
        		startActivity(i);
        	}
        });
        tvCreate= (TextView)findViewById(R.id.tvCreate);
        tvSettings= (TextView)findViewById(R.id.tvSettings);
        tvView= (TextView)findViewById(R.id.tvView);
        tvExit= (TextView)findViewById(R.id.tvSignOut);
tvCreate.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        		Intent i= new Intent(getApplicationContext(),CreateActivity.class);
        		startActivity(i);
        	}
        });
tvView.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent i= new Intent(getApplicationContext(),ViewDetailsActivity.class);
		startActivity(i);
	}
});
tvSettings.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent i= new Intent(getApplicationContext(),SettingsActivity.class);
		//i.putExtra(Profilename,PROFILENAME);
		startActivity(i);
	}
});
ibMenu=(ImageButton)findViewById(R.id.ibMenu);
ibMenu.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent i= new Intent(getApplicationContext(),HomeActivity.class);
		startActivity(i);
	}
});
    
    tvExit.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			AlertDialog.Builder alertBuilder= new AlertDialog.Builder(MenuActivity.this);
			alertBuilder.setTitle("SignOut Confirmation");
			alertBuilder.setMessage("Do you want to Sign Out the application..!");
			alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Intent i=new Intent(getApplicationContext(),ArcaneActivity.class);
					startActivity(i);
					finish();
				}
			});
				alertBuilder.setNegativeButton("No" ,new DialogInterface.OnClickListener(){
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
				AlertDialog alertDialog=alertBuilder.create();
				alertDialog.show();
				

			
		}
    });
    }
}
		


    
