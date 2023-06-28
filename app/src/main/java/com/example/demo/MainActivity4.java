package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

                dia.add(cursor.getString(1));
                sys.add(cursor.getString(2));
                heart.add(cursor.getString(0));
                dt.add(cursor.getString(4));
                tm.add(cursor.getString(3));
                heart.add(cursor.getString(5));
            }
        }
    }
}