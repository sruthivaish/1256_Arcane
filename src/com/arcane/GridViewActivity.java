package com.arcane;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class GridViewActivity extends Activity {
	 /** Called when the activity is first created. */
	TextView txtname,txtbankname,txtlocation,txtaccno,txtchequeno,txtlockerno,txtlockercode;
	GridView gridview=null;    
	@Override
	    
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.viewmaindetails);
	        txtname=(TextView)findViewById(R.id.tv1);
	        txtbankname=(TextView)findViewById(R.id.tv2);
	        txtlocation=(TextView)findViewById(R.id.tv3);
	        txtaccno=(TextView)findViewById(R.id.tv4);
	        txtchequeno=(TextView)findViewById(R.id.tv5);
	        txtlockerno=(TextView)findViewById(R.id.tv6);
	        txtlockercode=(TextView)findViewById(R.id.tv7);
	        gridview=(GridView)findViewById(R.id.gridView2);
	        final SQLiteDatabase arcaneDB = this.openOrCreateDatabase("Arcane.db", MODE_PRIVATE, null);
	        
	        Cursor c=arcaneDB.rawQuery("select * from BankDetails",null);
	        if(c!=null)
       	    {
       	   if(c.moveToFirst())
       	   {
       		   
       	   
       	 
	        do{	
	        	 String name=c.getString(c.getColumnIndex("Name"));
	        	 String bankname=c.getString(c.getColumnIndex("Bankname"));
	        	 String location=c.getString(c.getColumnIndex("Location"));
	        	 String accnum=c.getString(c.getColumnIndex("Accountnumber"));
	        	 String chequenum=c.getString(c.getColumnIndex("Chequebookno"));
	        	 String lockernum=c.getString(c.getColumnIndex("BankLockerNumber"));
	        	 String lockercode=c.getString(c.getColumnIndex("LockerCode"));
	        	 txtname.setText(name);
	        	 txtbankname.setText(bankname);
	        	 txtlocation.setText(location);
	        	 txtaccno.setText(accnum);
	        	 txtchequeno.setText(chequenum);
	        	 txtlockerno.setText(lockernum);
	        	 txtlockercode.setText(lockercode);
	        	 
	        		 
	        	 try
    			
    		    {
    			    		
    			String[] cols=new String[]{"_id","Name","Bankname","Location","Accountnumber","Chequebookno","BankLockerNumber","LockerCode"};
    			
    			int[] names=new int[]{R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView5,R.id.textView6,R.id.textView7};
    			
    			SimpleCursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),R.layout.main,c,cols,names);
    			
    			gridview.setAdapter(adapter);
    			//String[] items=dob.split("/");
    		    }
    		
    		
    		catch (Exception e) {
				// TODO: handle exception
    			e.printStackTrace();
			}
    		
    			}while(c.moveToNext());
	    
	       
	    	}
	       
	       

    
	}

}
}