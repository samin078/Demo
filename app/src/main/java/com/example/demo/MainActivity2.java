package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;


public class MainActivity2 extends AppCompatActivity {
    private CardView ins,shw;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ins=findViewById(R.id.insert);
        shw=findViewById(R.id.show);
        btn=findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });


        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
insertd();
            }
        });
        shw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }

    private void show() {
        Intent i = new Intent(MainActivity2.this, MainActivity4.class);
        startActivity(i);
        finish();
    }


    private void insertd() {
        Intent intent=new Intent(MainActivity2.this,MainActivity5.class);
        startActivity(intent);
        finish();
    }


}