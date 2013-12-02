package com.arcane;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends Activity {
    /** Called when the activity is first created. */
	ImageButton ibSignIn;
	TextView tvReset;
	EditText eusername,epassword;
	String Username,Password;
	
	ArrayList<String> results=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         results=new ArrayList<String>();
        setContentView(R.layout.signin);
        tvReset= (TextView)findViewById(R.id.tvReset);
        ibSignIn= (ImageButton)findViewById(R.id.ibSignIn);
        eusername=(EditText)findViewById(R.id.etxUserName);
        epassword=(EditText)findViewById(R.id.etxPassword);
        final SQLiteDatabase arcaneDB = this.openOrCreateDatabase("Arcane.db", MODE_PRIVATE, null);
        tvReset.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i= new Intent(getApplicationContext(),ForgotActivity.class);
				startActivity(i);
			}
		});
        
      ibSignIn.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		signinValidation();
		
		//Intent i= new Intent(getApplicationContext(),HomeActivity.class);
		//startActivity(i);
	}

	private void signinValidation() {
		
		// TODO Auto-generated method stub
		String USERNAME=eusername.getText().toString();
		String PASSWORD=epassword.getText().toString();
		Cursor c=arcaneDB.rawQuery("select * from Registration where Username='"+USERNAME+"' and Password='"+PASSWORD+"'",null);
		if(c!=null)
		{
			 if(c.moveToFirst())
			 {
				 do
				 {
					 Username=c.getString(c.getColumnIndex("Username"));
					 Password=c.getString(c.getColumnIndex("Password"));
		      			 //results.add(" "+Profile+" " +Password+"");
					  if((Username.equals(USERNAME)&& Password.equals(PASSWORD)))
						{
						 
						  ModelLocator.USER_NAME=Username;
							Intent i= new Intent(getApplicationContext(),HomeActivity.class);
						
							startActivity(i);
						}
					 
					  else
					  {
							Toast.makeText(getApplicationContext(), "ENTER CORRECT USERNAME OR PASSWORD", Toast.LENGTH_LONG).show();
					  }
					}while(c.moveToNext());
				
			 }
			 else
			  {
					Toast.makeText(getApplicationContext(), "ENTER CORRECT USERNAME OR PASSWORD", Toast.LENGTH_LONG).show();
			  }
		}
		
		
			
	}
});
}
}