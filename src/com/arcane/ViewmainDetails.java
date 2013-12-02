package com.arcane;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewmainDetails extends Activity{

     Button exit,delete;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewmaindetails);
		exit=(Button)findViewById(R.id.editbtn);
		delete=(Button)findViewById(R.id.Delete);
        exit.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        	}
        });
  delete.setOnClickListener(new View.OnClickListener() {
        	
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		
        	}
        });
	}
}
