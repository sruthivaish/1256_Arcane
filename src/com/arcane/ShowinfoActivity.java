package com.arcane;

import java.sql.SQLClientInfoException;
import java.sql.SQLData;
import java.util.ArrayList;

import android.R.string;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class ShowinfoActivity extends Activity {
    /** Called when the activity is first created.**/
	//GridView gridview=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewgrid);
    }
}