package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private ArrayList heart_id,dia_id,sys_id,tm_id,dt_id,com_id;

    public MyAdapter(Context context, ArrayList heart_id, ArrayList dia_id, ArrayList sys_id, ArrayList tm_id, ArrayList dt_id, ArrayList com_id) {
        this.context = context;
        this.heart_id = heart_id;
        this.dia_id = dia_id;
        this.sys_id = sys_id;
        this.tm_id = tm_id;
        this.dt_id = dt_id;
        this.com_id = com_id;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.heart_id.setText(String.valueOf(heart_id.get(position)));
        holder.dia_id.setText(String.valueOf(dia_id.get(position)));
        holder.sys_id.setText(String.valueOf(sys_id.get(position)));
        holder.tm_id.setText(String.valueOf(tm_id.get(position)));
        holder.dt_id.setText(String.valueOf(dt_id.get(position)));
        holder.com_id.setText(String.valueOf(com_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return heart_id.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
         TextView heart_id,dia_id,sys_id,tm_id,dt_id,com_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            heart_id=itemView.findViewById(R.id.hrtt);
            dia_id=itemView.findViewById(R.id.dias);
            sys_id=itemView.findViewById(R.id.sys);
            tm_id=itemView.findViewById(R.id.tmm);
            dt_id=itemView.findViewById(R.id.dt);
            com_id=itemView.findViewById(R.id.comm);
        }
    }
}
