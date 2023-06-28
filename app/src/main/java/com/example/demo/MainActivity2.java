package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;


public class MainActivity2 extends AppCompatActivity {
    private CardView hrt,bp1,ins,shw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       hrt=findViewById(R.id.hrt);
        bp1=findViewById(R.id.bp1);
        ins=findViewById(R.id.insert);
        shw=findViewById(R.id.show);


        hrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heartrate();
            }
        });

        bp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               bloodpressure();
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

    private void bloodpressure() {
        Intent i = new Intent(MainActivity2.this, StartVitalSigns1.class);
        startActivity(i);
        finish();
    }

    private void heartrate() {
        Intent i = new Intent(MainActivity2.this, StartVitalSigns.class);
        startActivity(i);
        finish();
    }

    private void insertd() {
        Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
        startActivity(intent);
        finish();
    }


}