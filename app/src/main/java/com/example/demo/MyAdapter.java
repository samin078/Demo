package com.example.demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DataClass> dataList;

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item1,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.dia_id.setText(dataList.get(position).getDataDia());
        holder.sys_id.setText(dataList.get(position).getDataSys());
        holder.heart_id.setText(dataList.get(position).getDataHrt());
        holder.tm_id.setText(dataList.get(position).getDataTime());
        holder.dt_id.setText(dataList.get(position).getDataDate());
        holder.com_id.setText(dataList.get(position).getDataCom());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("Diastolic",dataList.get(holder.getAdapterPosition()).getDataDia());
                intent.putExtra("Systolic",dataList.get(holder.getAdapterPosition()).getDataSys());
                intent.putExtra("HeartRate",dataList.get(holder.getAdapterPosition()).getDataHrt());
                intent.putExtra("Time",dataList.get(holder.getAdapterPosition()).getDataTime());
                intent.putExtra("Date",dataList.get(holder.getAdapterPosition()).getDataDate());
                intent.putExtra("Comment",dataList.get(holder.getAdapterPosition()).getDataCom());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}


class MyViewHolder extends RecyclerView.ViewHolder{
    TextView heart_id,dia_id,sys_id,tm_id,dt_id,com_id;
    CardView recCard;



    /* @NonNull
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
          TextView heart_id,dia_id,sys_id,tm_id,dt_id,com_id;*/
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        recCard=itemView.findViewById(R.id.recCard);
        heart_id=itemView.findViewById(R.id.hrtt);
        dia_id=itemView.findViewById(R.id.dias);
        sys_id=itemView.findViewById(R.id.sys);
        tm_id=itemView.findViewById(R.id.tmm);
        dt_id=itemView.findViewById(R.id.dt);
        com_id=itemView.findViewById(R.id.comm);
    }
}


