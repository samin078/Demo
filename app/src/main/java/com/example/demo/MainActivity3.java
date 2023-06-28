package com.example.demo;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;


public class MainActivity3 extends AppCompatActivity {
    EditText heart,sys,dias,date,time,comm;
    Button btn;
    SQLite DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        heart = findViewById(R.id.editTextTextPersonName6);
        sys= findViewById(R.id.editTextTextPersonName5);
        dias= findViewById(R.id.editTextTextPersonName4);
        date= findViewById(R.id.editTextDate);
        time= findViewById(R.id.editTextTime);
        comm=findViewById(R.id.editTextTextPersonName7);

        btn = findViewById(R.id.btn_update);

        DB=new SQLite(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String heartTXT,systolicTXT,diastolicTXT,dateTXT,timeTXT,comTXT;
                heartTXT = heart.getText().toString();
                systolicTXT = sys.getText().toString();
                diastolicTXT = dias.getText().toString();
                dateTXT = date.getText().toString();
                timeTXT = time.getText().toString();
                comTXT=comm.getText().toString();

                Boolean checkinsertdata=DB.insertuserdata(heartTXT,systolicTXT,diastolicTXT,dateTXT,timeTXT,comTXT);
                if(checkinsertdata==true){
                    Toast.makeText(MainActivity3.this, "New measurements are inserted", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(MainActivity3.this, "Found no measurements details", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity2.class));
    }
}