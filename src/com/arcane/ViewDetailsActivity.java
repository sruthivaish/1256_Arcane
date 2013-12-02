package com.arcane;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

@SuppressWarnings("deprecation")
public class ViewDetailsActivity extends Activity implements OnItemLongClickListener  {
    /** Called when the activity is first created. */
	ImageButton ibHome, ibMenu;
	EditText eviewpassword;
	Spinner typeview;
	Button btngo;
	String Password,dbpassword,Username;
	
	GridView gridview=null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdetails);
        gridview=(GridView)findViewById(R.id.gridView1);
        new ArrayList<String>();
        eviewpassword=(EditText)findViewById(R.id.viewpassword);
       typeview=(Spinner)findViewById(R.id.spnrType);
        btngo=(Button)findViewById(R.id.buttongo);
        ibHome=(ImageButton)findViewById(R.id.ibHome);
        ibMenu=(ImageButton)findViewById(R.id.ibMenu);
        
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

        btngo.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		 Cursor c1=arcaneDB.rawQuery("select * from ViewDetailsPassword where Username='"+ModelLocator.USER_NAME+"'",null);
        		 Cursor c3=arcaneDB.rawQuery("select * from Registration where Username='"+ModelLocator.USER_NAME+"'",null);
        		 String VIEWPASSWORD=eviewpassword.getText().toString();
        		 String PHONE=c3.getColumnName(c3.getColumnIndex("Phone"));
        		
        		if(c1!=null&&c1.moveToFirst())
        		Password=c1.getString(c1.getColumnIndex("Password"));
        		
        		//Username=c2.getString(c2.getColumnIndex("Username"));
        		Cursor c2=arcaneDB.rawQuery("select _id,Name,Type,Convert from Registration,CreateDetails where Registration.Username==CreateDetails.Username and CreateDetails.Username='"+ModelLocator.USER_NAME+"'",null);
        		
    			
        		if(c2!=null&&c2.moveToFirst())
        		{
        			
        			
        			if(VIEWPASSWORD.equals(Password))
        		 
        		     {
        			  try
        			  {
        				  String s="You have through your details";
        				  android.telephony.SmsManager smsManager=android.telephony.SmsManager.getDefault();
        				  smsManager.sendTextMessage(PHONE, null, s, null, null);
        				  Toast.makeText(getApplicationContext(), "sms sent", Toast.LENGTH_LONG).show();
        			  }
        			  catch (Exception e) {
						// TODO: handle exception
					      e.printStackTrace();
        			  }
        				do{	
        			try
        			
        		    {
        			typeview.getSelectedItem().toString();
        		
        			String[] cols=new String[]{"Name","Convert"};
        			
        			int[] names=new int[]{R.id.textView1,R.id.textView2};
        			
        			SimpleCursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),R.layout.viewgrid,c2,cols,names);
        			
        			gridview.setAdapter(adapter);
        			gridview.setOnItemLongClickListener(ViewDetailsActivity.this);
        		
        		    }
        		
        		
        		catch (Exception e) {
					// TODO: handle exception
        			e.printStackTrace();
				}
        		
        			}while(c2.moveToNext());
        			}else
        		  {
        			Toast.makeText(getApplicationContext(), "Enter Correct Password", Toast.LENGTH_LONG).show();
        		}
        		
        			
        			}
        	
        			}
        
        	
        });
    }
        @Override
        public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
        		long arg3) {
        	// TODO Auto-generated method stub
        	Cursor c2=(Cursor) arg0.getItemAtPosition(arg2);
        	String name=c2.getString(c2.getColumnIndex("Name"));

        	Intent i=new Intent(getApplicationContext(),GridViewActivity.class);
        	i.putExtra("name", name);
        	startActivity(i);
        	Toast.makeText(getApplicationContext(),"yourdetails",Toast.LENGTH_SHORT).show();
        	return false;
    }

    
}