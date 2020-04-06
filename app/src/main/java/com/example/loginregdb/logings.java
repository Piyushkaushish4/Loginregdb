package com.example.loginregdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class logings extends AppCompatActivity {
    EditText etuser,etpass;
    Button btlogin;
    Database mydb;
    TextView tv,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logings);
        etuser=findViewById(R.id.et_user);
        etpass=findViewById(R.id.et_pass);
        btlogin=findViewById(R.id.bt_login);
        tv=findViewById(R.id.txtfp);
        tv2=findViewById(R.id.txtnotuser);
       mydb=new Database(this);

       btlogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String user=etuser.getText().toString();
               String ps=etpass.getText().toString();
               String names = mydb.getUserData(user,ps);


               if(names.equals("found"))
               {
                   Intent intent8=new Intent(getApplicationContext(),navigatepage.class);
                   startActivity(intent8);
               }
               else
               {
                   Toast.makeText(logings.this, "Invalid", Toast.LENGTH_SHORT).show();
               }
           }
       });
       tv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent;
                 intent=new Intent(getApplicationContext(),forgotpass.class);
                 startActivity(intent);
           }
       });tv2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent;
                 intent=new Intent(getApplicationContext(),registers.class);
                 startActivity(intent);
           }
       });


    }
}
