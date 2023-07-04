package com.example.demo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity5 extends AppCompatActivity {
    EditText heart,sys,dias,date,time,comm;
    Button btn;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        heart = findViewById(R.id.editTextTextPersonName6);
        sys= findViewById(R.id.editTextTextPersonName5);
        dias= findViewById(R.id.editTextTextPersonName4);
        date= findViewById(R.id.editTextDate);
        time= findViewById(R.id.editTextTime);
        comm=findViewById(R.id.editTextTextPersonName7);

        btn = findViewById(R.id.btn_update);

       /* ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()== Activity.RESULT_OK){
                            Intent data=result.getData();
                            uri=data.getData();

                        }
                    }
                }
        );*/
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        saveData();
    }
});

    }
    public void saveData(){
        String diastolicTXT,systolicTXT,heartTXT,timeTXT,dateTXT,comTXT;


        diastolicTXT = dias.getText().toString();
        systolicTXT = sys.getText().toString();
        heartTXT = heart.getText().toString();
        timeTXT = time.getText().toString();
        dateTXT = date.getText().toString();
        comTXT=comm.getText().toString();


        DataClass dataClass=new DataClass(diastolicTXT,systolicTXT,heartTXT,timeTXT,dateTXT,comTXT);

        FirebaseDatabase.getInstance().getReference("Insert").child(diastolicTXT).setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity5.this,"New measurements are inserted",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity5.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}