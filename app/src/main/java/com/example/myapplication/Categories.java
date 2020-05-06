package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Categories extends AppCompatActivity {

    ImageView tops=(ImageView)findViewById(R.id.tops);
    ImageView bottoms=(ImageView)findViewById(R.id.bottoms);
    ImageView shoes=(ImageView)findViewById(R.id.shoes);
    ImageView makeup=(ImageView)findViewById(R.id.makeup);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshop);

        tops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Categories.this,Tops.class);
                startActivity(i);
            }
        });

        bottoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Categories.this,Bottoms.class);
                startActivity(i);
            }
        });

        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Categories.this,Shoes.class);
                startActivity(i);
            }
        });

        makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Categories.this,Makeup.class);
                startActivity(i);
            }
        });
    }
}
