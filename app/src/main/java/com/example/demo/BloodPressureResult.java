package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BloodPressureResult extends AppCompatActivity {

    private String user, Date;
    int SP, DP;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure_result);

        Date = df.format(today);
        TextView TBP = this.findViewById(R.id.BPT);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            SP = bundle.getInt("SP");
            DP = bundle.getInt("DP");
            user = bundle.getString("Usr");
            TBP.setText(SP + " / " + DP);
        }


    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(BloodPressureResult.this, MainActivity2.class);
        i.putExtra("Usr", user);
        startActivity(i);
        finish();
        super.onBackPressed();
    }
}