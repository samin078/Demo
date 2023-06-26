package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;


public class MainActivity2 extends AppCompatActivity {
    private CardView hrt,bp1,ins,shw;

    private String user;
    private int p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       hrt=this.findViewById(R.id.hrt);
        bp1=this.findViewById(R.id.bp1);
        ins=findViewById(R.id.insert);
        shw=findViewById(R.id.show);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            user = extras.getString("Usr");

        }
        hrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = 1;
                Intent i = new Intent(MainActivity2.this, StartVitalSigns.class);
                i.putExtra("Usr", user);
                i.putExtra("Page", p);
                startActivity(i);
                finish();
            }
        });

        bp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = 2;
                Intent i = new Intent(MainActivity2.this, StartVitalSigns.class);
                i.putExtra("Usr", user);
                i.putExtra("Page", p);
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
    }

    private void insertd() {
        Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, (arg0, arg1) -> {

                    MainActivity2.super.onBackPressed();
                    finish();
                    System.exit(0);
                }).create().show();
    }


}