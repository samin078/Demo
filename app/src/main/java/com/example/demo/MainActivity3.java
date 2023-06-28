package com.example.demo;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;


public class MainActivity3 extends AppCompatActivity {
    TextInputEditText heart,sys,dias,date,time;
    Button btn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        heart = findViewById(R.id.hr);
       sys= findViewById(R.id.sys);
        dias= findViewById(R.id.dia);
        date= findViewById(R.id.date);
        time= findViewById(R.id.tm);

        btn = findViewById(R.id.btn_update);
        progressBar = findViewById(R.id.progressBar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String heartr,systolic,diastolic,datee,timee;
                heartr = String.valueOf(heart.getText());
                systolic = String.valueOf(sys.getText());
              diastolic = String.valueOf(dias.getText());
                datee = String.valueOf(date.getText());
                timee = String.valueOf(time.getText());


                if(TextUtils.isEmpty(heartr)){
                    Toast.makeText(MainActivity3.this, "Insert heart rate", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(systolic)){
                    Toast.makeText(MainActivity3.this, "Insert Systolic Pressure", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(diastolic)){
                    Toast.makeText(MainActivity3.this, "Insert Diastolic Pressure", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(timee)){
                    Toast.makeText(MainActivity3.this, "Insert time value", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(datee)){
                    Toast.makeText(MainActivity3.this, "Insert date value", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}