package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1, e2, e3;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        e1 = (EditText)findViewById(R.id.email);
        e2 = (EditText)findViewById(R.id.pass);
        e3 = (EditText)findViewById(R.id.cpass);
        b1 = (Button)findViewById(R.id.register);
        b2 = (Button)findViewById(R.id.button2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);
                MainActivity.this.finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(s2.equals(s3)) {
                        boolean chkemail = db.chkemail(s1);
                        if (chkemail == true) {
                            boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Succesfully", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "E-mail already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Passwords don't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
/*
        FloatingActionButton fab = findViewById(R.id.register);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    }

}
