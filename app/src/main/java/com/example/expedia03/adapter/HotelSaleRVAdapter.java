package com.example.expedia03.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.expedia03.MyViewHolder;
import com.example.expedia03.OnRvItemListener;
import com.example.expedia03.activities.HotelInfoActivity;
import com.example.expedia03.entities.HotelData;
import com.example.expedia03.R;

import java.util.ArrayList;

public class HotelSaleRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements OnRvItemListener {
    private ArrayList<HotelData> dataList;
    Context mContext;

    public HotelSaleRVAdapter(ArrayList<HotelData> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.hotelsale_rv_item, parent, false);
        return new MyViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int pos) {
        MyViewHolder myViewHolder = (MyViewHolder)viewHolder;

        Glide.with(mContext).load(dataList.get(pos).getImage().getImgRes()).into(myViewHolder.hotelIv);
        myViewHolder.discountedRateTv.setText("-"+dataList.get(pos).getPercentage()+"%");
        myViewHolder.hotelNameTv.setText(dataList.get(pos).getName());
        myViewHolder.cityNameTv.setText(dataList.get(pos).getShortL());
        myViewHolder.scheduleTv.setText(dataList.get(pos).getSdate()+" ~ "+dataList.get(pos).getEdate());
        myViewHolder.hotelPriceTv.setText("￦"+dataList.get(pos).getPriced());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onRvItemClick(int pos) {
        HotelData data = dataList.get(pos);
        Intent hotelInfoIntent = new Intent(mContext, HotelInfoActivity.class);
        hotelInfoIntent.putExtra("hotelData", data);
        mContext.startActivity(hotelInfoIntent);
    }

/*    public static class MyViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView hotelIv;
        TextView hotelNameTv, cityNameTv, scheduleTv, hotelPriceTv, discountedRateTv;

        MyViewHolder(View view){
            super(view);
            hotelIv = view.findViewById(R.id.recyclerview_item_iv);
            hotelNameTv = view.findViewById(R.id.recyclerview_item_hotelname);
            cityNameTv = view.findViewById(R.id.recyclerview_item_cityname);
            scheduleTv = view.findViewById(R.id.recyclerview_item_schedule);
            hotelPriceTv = view.findViewById(R.id.recyclerview_item_hotelprice);
            discountedRateTv = view.findViewById(R.id.recyclerview_item_discountedrate);
        }

    }*/
}
