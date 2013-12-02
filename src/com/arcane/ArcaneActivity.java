package com.arcane;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ArcaneActivity extends Activity {
    /** Called when the activity is first created. */
	TextView tvSignIn, tvRegister;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        tvSignIn= (TextView)findViewById(R.id.tvSignIn);
        tvRegister= (TextView)findViewById(R.id.tvRegister);
        
tvRegister.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i= new Intent(getApplicationContext(),RegisterActivity.class);
				startActivity(i);
			}
		});
        
        tvSignIn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i= new Intent(getApplicationContext(), SignInActivity.class);
				startActivity(i);
			}
		});
        
        
    }
}