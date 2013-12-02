package com.arcane;

import java.security.PublicKey;
import java.text.BreakIterator;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	/** Called when the activity is first created. */
	EditText edUsername,edProfilname,edDOB,edPassword,edPhno,edAnswer,edconfirmpassword;
	Spinner edquestion;
	ImageButton ibRegister;
	String Profilename;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
    
		super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        edUsername=(EditText)findViewById(R.id.etxUserName);
        edProfilname=(EditText)findViewById(R.id.etxProfileName);
        edDOB=(EditText)findViewById(R.id.etxDOB);
        edPassword=(EditText)findViewById(R.id.etxPassword);
        edconfirmpassword=(EditText)findViewById(R.id.etxRePassword);
        edPhno=(EditText)findViewById(R.id.etxPhone);
        //edSecQuestID=(EditText)findViewById(R.id.spnrSecQuest);
        edAnswer=(EditText)findViewById(R.id.etxAnswer);
        edquestion=(Spinner)findViewById(R.id.spnrSecQuest);
        final SQLiteDatabase arcaneDB = this.openOrCreateDatabase("Arcane.db", MODE_PRIVATE, null);
        
        ibRegister= (ImageButton)findViewById(R.id.ibRegister);
        ibRegister.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		saveArcaneUserDetails();
        		//Toast.makeText(getApplicationContext(), "Registration Sucessfull", 10).show();
        		//Intent i= new Intent(getApplicationContext(),SignInActivity.class);
        		//startActivity(i);
        		//Toast.makeText(getApplicationContext(), "Registration Sucessfull", 100).show();
        	}

			private void saveArcaneUserDetails() {
				// TODO Auto-generated method stub
				
					
	        		
					String UNAME= edUsername.getText().toString();
	        		String PROFILENAME= edProfilname.getText().toString();
	        		String DOBIRTH= edDOB.getText().toString();
	        		//int DOB=Integer.parseInt(DOBIRTH);
	        		String PASSWORD= edPassword.getText().toString();
	        		String CONFIRMPASSWORD=edconfirmpassword.getText().toString();
	        		String PHONE= edPhno.getText().toString();
	        		long PHONENO=Long.parseLong(PHONE);
	        		//String SQ_ID=edSecQuestID.getText().toString();
	        		String SQUESTION=edquestion.getSelectedItem().toString();
	        		String ANSWER=edAnswer.getText().toString();
	        		arcaneDB.execSQL("CREATE TABLE IF NOT EXISTS Registration (Username NCHAR(150) NOT NULL unique, Profilename NCHAR(105) NOT NULL,DOB NCHAR(10) NOT NULL,Password NCHAR(105) NOT NULL,Phone BIGINT(10) NOT NULL,Question NCHAR(600) NOT NULL,Answer NCHAR(255) NOT NULL)");
	        		if(PASSWORD.equals(CONFIRMPASSWORD))
	        		{
	        			
	        			try{
	        		
	        		arcaneDB.execSQL("insert into Registration values('"+UNAME+"','"+PROFILENAME+"','"+DOBIRTH+"','"+PASSWORD+"','"+PHONE+"','"+SQUESTION+"','"+ANSWER+"')");
	        	   
	        	    Toast.makeText(getApplicationContext(), "Registration Sucessfull", 10).show();
	        		Intent i= new Intent(getApplicationContext(),SignInActivity.class);
	        		
	        		startActivity(i);
	        			
	        			}catch(Exception e){
	        				e.printStackTrace();
	        			}
	        		}
        			
        			
    		else
    		{
        		Toast.makeText(getApplicationContext(), "Passwords are not same.Try again", Toast.LENGTH_LONG).show();

	        		//Intent i= new Intent(getApplicationContext(), RegisterActivity.class);
	        		//startActivity(i);
			}
			}
			});
       		 		
        
        }    
}
        
