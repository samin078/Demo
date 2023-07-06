package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailActivity extends AppCompatActivity {
    TextView detaildia,detailsys,detailhrt,detailtm,detaildt,detailcm;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detaildia=findViewById(R.id.dias);
        detailsys=findViewById(R.id.sys);
        detailhrt=findViewById(R.id.heart);
        detailtm=findViewById(R.id.time);
        detaildt=findViewById(R.id.date);
        detailcm=findViewById(R.id.comment);
        editButton = findViewById(R.id.editButton);
        deleteButton = findViewById(R.id.deleteButton);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            detaildia.setText("Diastolic: " + bundle.getString("Diastolic"));
            detailsys.setText("Systolic: " + bundle.getString("Systolic"));
            detailhrt.setText("Heart Rate: " + bundle.getString("HeartRate"));
            detailtm.setText("Time: " + bundle.getString("Time"));
            detaildt.setText("Date: " + bundle.getString("Date"));
            detailcm.setText("Comment: " + bundle.getString("Comment"));

            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");

        }

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Insert");
                FirebaseStorage storage = FirebaseStorage.getInstance();

                reference.child(key).removeValue();
                Toast.makeText(DetailActivity.this,"Deleted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                finish();
/*
                //StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                StorageReference storageReference = storage.getReference();
                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(DetailActivity.this,"Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                        finish();
                    }
                });*/


            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class)
                        .putExtra("Dia", detaildia.getText().toString())
                        .putExtra("Sys", detailsys.getText().toString())
                        .putExtra("Heart", detailhrt.getText().toString())
                        .putExtra("Time", detailtm.getText().toString())
                        .putExtra("Date", detaildt.getText().toString())
                        .putExtra("Comm", detailcm.getText().toString())
                        .putExtra("Key", key);

                startActivity(intent);

            }
        });
    }
}