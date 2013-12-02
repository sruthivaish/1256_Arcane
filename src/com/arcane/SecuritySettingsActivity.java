package com.arcane;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class SecuritySettingsActivity extends Activity {
    /** Called when the activity is first created. */
	ImageButton ibHome, ibMenu, ibUpdateDetails;
	Spinner spinquestion;
	EditText eans,enewpswd,econfirmpswd,eUsername;
	String  dbquestion,dbans,dbusername;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.securitysettings);
        ibHome=(ImageButton)findViewById(R.id.ibHome);
        spinquestion=(Spinner)findViewById(R.id.spnrSecQuest);
        eans=(EditText)findViewById(R.id.etxAnswer);
        
        enewpswd=(EditText)findViewById(R.id.etxnewPassword);
        eUsername=(EditText)findViewById(R.id.etxUsername);
        econfirmpswd=(EditText)findViewById(R.id.repswd);
        final SQLiteDatabase arcaneDB = this.openOrCreateDatabase("Arcane.db", MODE_PRIVATE, null);
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
        ibUpdateDetails=(ImageButton)findViewById(R.id.ibUpdateDetails);
       
        ibUpdateDetails.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        		 String ANSWER=eans.getText().toString();	
        	     String QUESTION=spinquestion.getSelectedItem().toString();
        	     	
        	    String NEWPASSWORD=enewpswd.getText().toString();
        	     String CONFIRMPASSWORD=econfirmpswd.getText().toString();
        	     String USERNAME=eUsername.getText().toString();
        	   Cursor c=arcaneDB.rawQuery("select * from Registration WHERE Username='"+ModelLocator.USER_NAME+"' ",null);
				
        	   if(c!=null)
				{
					 if(c.moveToFirst())
					 {
						 do
						 {
							 dbquestion=c.getString(c.getColumnIndex("Question"));
							  dbans=c.getString(c.getColumnIndex("Answer"));
							  dbusername=c.getString(c.getColumnIndex("Username"));
							  arcaneDB.execSQL("CREATE TABLE IF NOT EXISTS ViewDetailsPassword(Password NCHAR(105) NOT NULL,Username NCHAR(150) NOT NULL unique)");
							  if(dbusername.equals(USERNAME))
							 {
								 if(dbquestion.equals(QUESTION)&&dbans.equals(ANSWER)&&NEWPASSWORD.equals(CONFIRMPASSWORD))
							  {
								  arcaneDB.execSQL("insert into ViewDetailsPassword values('"+NEWPASSWORD+"','"+USERNAME+"')");
								  //Toast.makeText(getApplicationContext(), "UPDATED SUCCESSFULLY", Toast.LENGTH_LONG).show();
								 
							  }
								 else{
									 Toast.makeText(getApplicationContext(), "Enter correct username", 10).show();
								 }
									 
							 } 
						 
						 }while(c.moveToNext());
					 }
				}
        	
        	   
        		Intent i= new Intent(getApplicationContext(),SettingsActivity.class);
        		startActivity(i);
        		 Toast.makeText(getApplicationContext(), "Updated Sucessfully", 10).show();
        	}
        }); 
}
}