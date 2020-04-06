package com.example.loginregdb;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class showpage extends AppCompatActivity {
    ArrayList<Student> arrayList;
    ListView listView;
    Button view;
    Database mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showpage);
        mydb=new Database(this);
                arrayList=mydb.getData();
                adapter adapter =new adapter(getApplicationContext(),arrayList);
                listView.setAdapter(adapter);
        
    }
}
