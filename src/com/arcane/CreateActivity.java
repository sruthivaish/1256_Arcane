package com.arcane;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateActivity extends Activity {
    /** Called when the activity is first created. */
	ImageButton ibHome, ibMenu;
	Button btnSave,btnenterdetails;
	Spinner spintype,spincode;
	EditText ename,ebankname,elocation,eaccnum,echequeno,elokerno,elockercode;
	EditText ecardname,eissuedauthority,ecardnum,ecarddetails,ecardpin,eissuedon,evalidity;
	EditText eemails,epassword,ephone;
	LinearLayout bank,card,others;
	String BANKNAME,LOCATION,ACCOUNTNUM,CHEQUEBOOKNUM,LOCKERNUM,LOCKERCODE,NAME,CARDNAME,ISSUEDAUTHORITY,CARDNUMBER,CARDDETAILS,CARDPIN,ISSUEDON,VAIDITY;
	String EMAILS,PASSWORD,PHONE;
	String type=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        ibHome=(ImageButton)findViewById(R.id.ibHome);
        ibMenu=(ImageButton)findViewById(R.id.ibMenu);
        btnenterdetails=(Button)findViewById(R.id.btnEnter);
        
        ename=(EditText)findViewById(R.id.name);
        ebankname=(EditText)findViewById(R.id.edtbnkname);
        elocation=(EditText)findViewById(R.id.edlocation);
        eaccnum=(EditText)findViewById(R.id.edacno);
        echequeno=(EditText)findViewById(R.id.edchequeno);
        elokerno=(EditText)findViewById(R.id.edlockerno);
        elockercode=(EditText)findViewById(R.id.edcode);
        
        ecardname=(EditText)findViewById(R.id.edCardname);
        eissuedauthority=(EditText)findViewById(R.id.edauthority);
        ecardnum=(EditText)findViewById(R.id.edcardno);
        ecarddetails=(EditText)findViewById(R.id.edcarddetails);
        ecardpin=(EditText)findViewById(R.id.edcardpin);
        eissuedon=(EditText)findViewById(R.id.edissuedon);
        evalidity=(EditText)findViewById(R.id.edvalidity);
        
        eemails=(EditText)findViewById(R.id.edemail);
        epassword=(EditText)findViewById(R.id.edpswd);
        ephone=(EditText)findViewById(R.id.edphone);
        
        btnSave=(Button)findViewById(R.id.btnSave);
        spintype=(Spinner)findViewById(R.id.spnrType);
        spincode=(Spinner)findViewById(R.id.spnrGenerate);
        bank=(LinearLayout)findViewById(R.id.banklayout);
        card=(LinearLayout)findViewById(R.id.cardlayout);
        others=(LinearLayout)findViewById(R.id.otherslayout);
        final SQLiteDatabase arcaneDB = this.openOrCreateDatabase("Arcane.db", MODE_PRIVATE, null);
        ibHome.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        		Intent i= new Intent(getApplicationContext(),HomeActivity.class);
        		startActivity(i);
        	}
        });
        
        ibMenu.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        		Intent i= new Intent(getApplicationContext(),MenuActivity.class);
        		startActivity(i);
        	}
        });
        
       
        btnenterdetails.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		type=spintype.getSelectedItem().toString();
        		if(type.equals("Bank Details"))
        		{
        			bank.setVisibility(View.VISIBLE);
        			card.setVisibility(View.GONE);
        			others.setVisibility(View.GONE);
        			
        			
        			
        		}
        		else if(type.equals("Card Details"))
        		{
        			bank.setVisibility(View.GONE);
        			card.setVisibility(View.VISIBLE);
        			others.setVisibility(View.GONE);
        			
        		}
        		else if(type.equals("Others"))
        		{
        			bank.setVisibility(View.GONE);
        			card.setVisibility(View.GONE);
        			others.setVisibility(View.VISIBLE);
        			
        		}
        		
        		
        	}
        });
    btnSave.setOnClickListener(new View.OnClickListener() {
        	
	      
	 public void onClick(View v) {
        		// TODO Auto-generated method stub
		        saveDetails();
        		
	   }

	private void saveDetails() {
		// TODO Auto-generated method stub
		try
		{
			if(type.equals("Bank Details"))
			{
				String NAME= ename.getText().toString();
        		String BANKNAME= ebankname.getText().toString();
        		String LOCATION= elocation.getText().toString();
        		String ACCOUNTNUM= eaccnum.getText().toString();
        		String CHEQUEBOOKNUM=echequeno.getText().toString();
        		String LOCKERNUM= elokerno.getText().toString();
        		String LOCKERCODE= elockercode.getText().toString();
                
                String spinconvert=spincode.getSelectedItem().toString();
        		arcaneDB.execSQL("CREATE TABLE IF NOT EXISTS CreateDetails(_id,Name NCHAR(300) NOT NULL,Type NCHAR(300) NOT NULL,Convert NCHAR(150) NOT NULL,Username NCHAR(150) NOT NULL)");
        		arcaneDB.execSQL("insert into CreateDetails values("+1+",'"+NAME+"','"+type+"','"+spinconvert+"','"+ModelLocator.USER_NAME+"')");
        		arcaneDB.execSQL("CREATE TABLE IF NOT EXISTS BankDetails(_id,Name NCHAR(300) NOT NULL,Bankname NCHAR(800),Location NCHAR(800),Accountnumber NCHAR(800),Chequebookno NCHAR(60),BankLockerNumber NCHAR(60),LockerCode NCHAR(60))");
				arcaneDB.execSQL("insert into BankDetails values("+1+",'"+NAME+"','"+BANKNAME+"','"+LOCATION+"','"+ACCOUNTNUM+"','"+CHEQUEBOOKNUM+"','"+LOCKERNUM+"','"+LOCKERCODE+"')");
		
			
			}
			else if(type.equals("Card Details"))
			{
				String NAME= ename.getText().toString();
        		String CARDNAME= ecardname.getText().toString();
        		String ISSUEDAUTHORITY= eissuedauthority.getText().toString();
        		String CARDNUMBER= ecardnum.getText().toString();
        		String CARDDETAILS= ecarddetails.getText().toString();
        		String CARDPIN= ecardpin.getText().toString();
        		String ISSUEDON= eissuedon.getText().toString();
        		String VAIDITY= evalidity.getText().toString();
        		String spinconvert=spincode.getSelectedItem().toString();
        		arcaneDB.execSQL("CREATE TABLE IF NOT EXISTS CreateDetails(_id,Name NCHAR(300) NOT NULL,Type NCHAR(300) NOT NULL,Convert NCHAR(150) NOT NULL,Username NCHAR(150) NOT NULL)");
        		arcaneDB.execSQL("insert into CreateDetails values("+1+",'"+NAME+"','"+type+"','"+spinconvert+"','"+ModelLocator.USER_NAME+"')");
        		arcaneDB.execSQL("CREATE TABLE IF NOT EXISTS CardDetails(_id,Name NCHAR(300) NOT NULL,Cardname NCHAR(300),Issuedauthority NCHAR(300),Cardnumber NCHAR(150),Carddetails NCHAR(300),Cardpin NCHAR(30),Issuedon NCHAR(10),Validtill NCHAR(10))");
				arcaneDB.execSQL("insert into CardDetails values("+1+",'"+NAME+"','"+CARDNAME+"','"+ISSUEDAUTHORITY+"','"+CARDNUMBER+"','"+CARDDETAILS+"','"+CARDPIN+"','"+ISSUEDON+"','"+VAIDITY+"')");
				
			}
			else if(type.equals("Others"))
			{
				String NAME= ename.getText().toString();
        		String EMAILS= eemails.getText().toString();
        		String PASSWORD= epassword.getText().toString();
        		String PHONE= ephone.getText().toString();
        		long PHONENO=Long.parseLong(PHONE);
        		
        		String spinconvert=spincode.getSelectedItem().toString();
        		arcaneDB.execSQL("CREATE TABLE IF NOT EXISTS CreateDetails(_id,Name NCHAR(300) NOT NULL,Type NCHAR(300) NOT NULL,Convert NCHAR(150) NOT NULL,Username NCHAR(150) NOT NULL)");
        		arcaneDB.execSQL("insert into CreateDetails values("+1+",'"+NAME+"','"+type+"','"+spinconvert+"','"+ModelLocator.USER_NAME+"')");
        		arcaneDB.execSQL("CREATE TABLE IF NOT EXISTS OtherDetails(_id,Name NCHAR(300) NOT NULL,Emailid NCHAR(105),Password NCHAR(150),Phonenum BIGINT(10))");
				arcaneDB.execSQL("insert into OtherDetails values("+1+",'"+NAME+"','"+EMAILS+"','"+PASSWORD+"','"+PHONE+"')");
			}
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Intent i= new Intent(getApplicationContext(),MenuActivity.class);
		startActivity(i);
		 Toast.makeText(getApplicationContext(), "Sucessfully Completed", 10).show();
	}   	
	 
        });
    }
    }
