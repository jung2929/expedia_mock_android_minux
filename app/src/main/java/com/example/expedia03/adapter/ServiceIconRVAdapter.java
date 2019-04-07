package com.example.expedia03.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.expedia03.MyViewHolder;
import com.example.expedia03.OnRvItemListener;
import com.example.expedia03.R;
import com.example.expedia03.activities.HotelInfoActivity;
import com.example.expedia03.entities.HotelData;

import java.util.ArrayList;

public class ServiceIconRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<String> dataList;
    Context mContext;

    public ServiceIconRVAdapter(ArrayList<String> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.hotelinfo_serviceicon_rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int pos) {
        MyViewHolder myViewHolder = (MyViewHolder)viewHolder;

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
