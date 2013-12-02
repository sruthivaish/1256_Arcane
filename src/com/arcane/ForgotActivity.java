package com.arcane;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class ForgotActivity extends Activity {
    /** Called when the activity is first created. */
	ImageButton ibUpdate=null;
	EditText eusername,epassword,econfirmpassword,eans=null;
	Button btnget;
	Spinner squestion=null;
	String username,USERNAME,QUESTION,PASSWORD,CONFIRMPASSWORD,dbquestion,dbans,ANS=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot);
        final SQLiteDatabase arcaneDB = this.openOrCreateDatabase("Arcane.db", MODE_PRIVATE, null);
        ibUpdate= (ImageButton)findViewById(R.id.ibUpdate);
        eusername=(EditText)findViewById(R.id.etxUserName);
        squestion=(Spinner)findViewById(R.id.spnrSecQuest);
        epassword=(EditText)findViewById(R.id.etxPassword);
        eans=(EditText)findViewById(R.id.etxAnswer);
        econfirmpassword=(EditText)findViewById(R.id.etxREPassword);
        //btnget=(Button)findViewById(R.id.ibgo);
        ibUpdate.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        	     USERNAME=eusername.getText().toString();	
        	     QUESTION=squestion.getSelectedItem().toString();
        	     PASSWORD=epassword.getText().toString();	
        	     CONFIRMPASSWORD=econfirmpassword.getText().toString();
        	     ANS=eans.getText().toString();
        	 	Cursor c=arcaneDB.rawQuery("select * from Registration",null);
				if(c!=null)
				{
					 if(c.moveToFirst())
					 {
						 do
						 {
							  username=c.getString(c.getColumnIndex("Username"));
							  
				      			 //results.add(" "+Profile+" " +Password+"");
							  if(username.equals(USERNAME))
								{
								  Cursor c1=arcaneDB.rawQuery("select Question,Answer from Registration where Username='"+username+"'",null);
								 if(c1.moveToFirst())
								 {
								  dbquestion=c1.getString(c1.getColumnIndex("Question"));
								  dbans=c1.getString(c1.getColumnIndex("Answer"));
								 }
								  if(dbquestion.equals(QUESTION)&&dbans.equals(ANS)&&PASSWORD.equals(CONFIRMPASSWORD))
								  {
									  arcaneDB.execSQL("update Registration set Password='"+PASSWORD+"' where Username='"+username+"'");
									  Toast.makeText(getApplicationContext(), "UPDATED SUCCESSFULLY", Toast.LENGTH_LONG).show();
									  Intent i= new Intent(getApplicationContext(),SignInActivity.class);
										startActivity(i);
								  }
									
								}
								else
								{
									Toast.makeText(getApplicationContext(), "ENTER CORRECT USERNAME OR PASSWORD", Toast.LENGTH_LONG).show();

								}
						 }while(c.moveToNext());
					 }
				}
        	
        	   
        	}

			
        });


        
}
}