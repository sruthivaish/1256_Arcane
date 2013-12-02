package com.arcane;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends Activity {
    /** Called when the activity is first created. */
	ImageButton ibMenu;
	String Profilename,PROFILENAME;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        

        ibMenu=(ImageButton)findViewById(R.id.ibMenu);
        TextView welcomenote=(TextView)findViewById(R.id.welcomenote);
        final SQLiteDatabase arcaneDB = this.openOrCreateDatabase("Arcane.db", MODE_PRIVATE, null);
        Cursor c=arcaneDB.rawQuery("select * from Registration where Username='"+ModelLocator.USER_NAME+"'",null);
        if(c!=null&&c.moveToFirst())
        {
        	Profilename=c.getString(c.getColumnIndex("Profilename"));
        	ModelLocator.USER_PROFILE=Profilename;
        String msg="Hi,'"+Profilename+"'.Welcome to the home page of High confidential security Application.This application is used to stores your secret information in a confidential way by providing a human unreadable format of your data";
     welcomenote.setText(msg);
        }
        ibMenu.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        		Intent i= new Intent(getApplicationContext(),MenuActivity.class);
        		i.putExtra(Profilename,PROFILENAME);
        		startActivity(i);
        	}
        });
        

}
}
