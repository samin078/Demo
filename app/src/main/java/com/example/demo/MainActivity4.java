package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> heart,dia,sys,tm,dt,cm;
    SQLite DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        DB=new SQLite(this);
        heart=new ArrayList<>();
        dia=new ArrayList<>();
        sys=new ArrayList<>();
        tm=new ArrayList<>();
       dt=new ArrayList<>();
        cm=new ArrayList<>();
        recyclerView=findViewById(R.id.rr);
        adapter=new MyAdapter(this,heart,dia,sys,tm,dt,cm);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor= DB.getdata();
        if (cursor.getCount()==0)
        {
            Toast.makeText(MainActivity4.this,"No Entry Exists",Toast.LENGTH_SHORT).show();

        }
        else
        {
            while (cursor.moveToNext())
            {
                heart.add(cursor.getString(1));
                dia.add(cursor.getString(2));
                sys.add(cursor.getString(3));
                tm.add(cursor.getString(4));
                dt.add(cursor.getString(5));
                heart.add(cursor.getString(6));
            }
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity2.class));
    }
}