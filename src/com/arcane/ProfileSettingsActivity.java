package com.arcane;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.Toast;

public class ProfileSettingsActivity extends Activity {
    /** Called when the activity is first created. */
	ImageButton ibHome, ibMenu;
	EditText eprofilename,ephonenum;
	Button btnUpdate,btneditprofilename,btneditphone;
	String Profilename;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilesettings);
        ibHome=(ImageButton)findViewById(R.id.ibHome);
        eprofilename=(EditText)findViewById(R.id.editprofile);
        
        ephonenum=(EditText)findViewById(R.id.editphno);
       
       
        btnUpdate=(Button)findViewById(R.id.btnUpdate);
        final SQLiteDatabase arcaneDB = this.openOrCreateDatabase("Arcane.db", MODE_PRIVATE, null);
    	Cursor c=arcaneDB.rawQuery("select * from Registration where Username='"+ModelLocator.USER_NAME+"'",null);
		if(c!=null)
		{
			 if(c.moveToFirst())
			 {
				 
					
						
						  
						 String pname=c.getString(c.getColumnIndex("Profilename"));
						 String pno=c.getString(c.getColumnIndex("Phone"));
						
						 //eprofilename.setText(pname);
						 //ephonenum.setText(pno);
				
			 }
		}
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
       
        
        
        	/*	btneditprofilename.setOnClickListener(new View.OnClickListener() {
        	        	
        	        	public void onClick(View v) {
        	        		// TODO Auto-generated method stub
        		
        		
        		
        		
        	        	}
                });*/
        		 
        		
        		
        		
         		
        		btnUpdate.setOnClickListener(new View.OnClickListener() {
                	
                	public void onClick(View v) {
                		// TODO Auto-generated method stub
                		
                				 String EProfilename=eprofilename.getText().toString();
                				 String EPhone=ephonenum.getText().toString();
                						
                						  
       arcaneDB.execSQL("update Registration set Profilename='"+EProfilename+"' where Username='"+ModelLocator.USER_NAME+"'");
                						
       arcaneDB.execSQL("update Registration set Phone='"+EPhone+"' where Username='"+ModelLocator.USER_NAME+"'");			 
                					
                			
                			 
                		
        		Intent i1= new Intent(getApplicationContext(),SettingsActivity.class);
         		startActivity(i1);
         		 Toast.makeText(getApplicationContext(), "Updated Sucessfully", 1000).show();
        	}
        });
       
    }
}