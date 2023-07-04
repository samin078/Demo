package com.example.demo;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;


public class MainActivity3 extends AppCompatActivity {
    EditText heart,sys,dias,date,time,comm;
    Button btn,btn1;


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





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean er;
                String heartTXT,systolicTXT,diastolicTXT,dateTXT,timeTXT,comTXT;
                heartTXT = heart.getText().toString();
                systolicTXT = sys.getText().toString();
                diastolicTXT = dias.getText().toString();
                dateTXT = date.getText().toString();
                timeTXT = time.getText().toString();
                comTXT=comm.getText().toString();


                if(heartTXT.isEmpty())
                {
                    heart.setError("Required");
                    er=true;
                }
                else if(Integer.parseInt(heartTXT)<30)
                {
                    heart.setError("Minimum Value is 30");
                    er=true;
                }
                else if(Integer.parseInt(heartTXT)>120)
                {
                    heart.setError("Maximum Value is 120");
                    er=true;
                }

                if(systolicTXT.isEmpty())
                {
                    sys.setError("Required");
                    er=true;
                }
                else if(Integer.parseInt(systolicTXT)<60)
                {
                    sys.setError("Minimum Value is 60");
                    er=true;

                }
                else if(Integer.parseInt(systolicTXT)>150)
                {
                    sys.setError("Maximum Value is 150");
                    er=true;
                }


                if(dias.getText().toString().isEmpty())
                {
                    dias.setError("Required");
                    er=true;
                }
                else if(Integer.parseInt(diastolicTXT)<100)
                {
                    dias.setError("Minimum Value is 100");
                    er=true;
                }
                else if(Integer.parseInt(diastolicTXT)>200)
                {
                    dias.setError("Maximum Value is 200");
                    er=true;
                }





               /* StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Diastolic Pressure:"+res.getString(0)+"mmHg\n");
                    buffer.append("Systolic Pressure:"+res.getString(1)+"mmHg\n");
                    buffer.append("Heart Rate:"+res.getString(2)+"bpm\n");
                    buffer.append("Time:"+res.getString(3)+"\n");
                    buffer.append("Date:"+res.getString(4)+"\n");
                    buffer.append("Comment:"+res.getString(5)+"\n\n");
                }

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity3.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();*/
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity2.class));
    }
}