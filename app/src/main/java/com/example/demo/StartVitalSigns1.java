package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StartVitalSigns1 extends AppCompatActivity {
    ImageButton VS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_vital_signs1);


       VS = findViewById(R.id.StartVS);

        VS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartVitalSigns1.this, BloodPressureProcess.class);
                startActivity(i);
                finish();
            }
        });
    }
}
