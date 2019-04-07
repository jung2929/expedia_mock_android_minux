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
import com.example.expedia03.R;
import com.example.expedia03.activities.HotelSaleActivity;
import com.example.expedia03.entities.HotelData;
import com.example.expedia03.entities.HotelSaleData;

import java.util.ArrayList;

public class BookingTabRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements OnRvItemListener {
    static final int HOTELSALE_UNDER80000 = 15;
    static final int HOTELSALE_DAILY = 16;
    static final int HOTELSALE_DEADLINE = 17;

    private ArrayList<HotelSaleData> dataList;
    View view;
    Context mContext;

    public BookingTabRVAdapter(ArrayList<HotelSaleData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos) {
        mContext = parent.getContext();
        view = LayoutInflater.from(mContext).inflate(R.layout.bookingtab_rv_item, parent, false);
        return new MyViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int pos) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        Glide.with(mContext).load(dataList.get(pos).getCardImg()).into(myViewHolder.ivCardImg);
        myViewHolder.saleTitle.setText(dataList.get(pos).getSaleTite());
        myViewHolder.saleGuide.setText(dataList.get(pos).getSaleGuide());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onRvItemClick(int pos) {
        switch (dataList.get(pos).getSaleType()) {
            case HOTELSALE_UNDER80000:
                Intent under80000Intent = new Intent(mContext, HotelSaleActivity.class);
                under80000Intent.putExtra("pageset", HOTELSALE_UNDER80000);
                mContext.startActivity(under80000Intent);
                break;
            case HOTELSALE_DAILY:
                Intent dailyIntent = new Intent(mContext, HotelSaleActivity.class);
                dailyIntent.putExtra("pageset", HOTELSALE_DAILY);
                mContext.startActivity(dailyIntent);
                break;
            case HOTELSALE_DEADLINE:
                Intent deadLineIntent = new Intent(mContext, HotelSaleActivity.class);
                deadLineIntent.putExtra("pageset", HOTELSALE_DEADLINE);
                mContext.startActivity(deadLineIntent);
                break;
        }
    }
}
