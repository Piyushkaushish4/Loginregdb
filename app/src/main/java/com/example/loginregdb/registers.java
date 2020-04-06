package com.example.loginregdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registers extends AppCompatActivity {
    EditText etname,etemail,etuname,etpword,etcpword;
    Button btregister,btnext;
    Database mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registers);
        etname=findViewById(R.id.et_name);
        etemail=findViewById(R.id.et_email);
        etuname=findViewById(R.id.et_uname);
        etpword=findViewById(R.id.et_pword);
        etcpword=findViewById(R.id.et_cpword);



        btnext=findViewById(R.id.bt_next);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next=new Intent(getApplicationContext(),logings.class);
                startActivity(next);
            }
        });
        mydb=new Database(this);
        btregister=findViewById(R.id.bt_register);
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=etname.getText().toString().trim();
                String useremail=etemail.getText().toString().trim();
                String userusername=etuname.getText().toString().trim();
                String userpassword=etpword.getText().toString().trim();
                Boolean result= mydb.insertdata(username,useremail,userusername,userpassword);
                if(result==true)
                {
                    Toast.makeText(registers.this, "Data successfully saved", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(registers.this, "Not saved Retry", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
