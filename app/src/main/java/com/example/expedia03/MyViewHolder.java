package com.example.expedia03;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView saleTitle, saleGuide;
    public RoundedImageView ivCardImg;
    public TextView hotelNameTv, cityNameTv, scheduleTv, hotelPriceTv, discountedRateTv;
    public RoundedImageView hotelIv;

    public MyViewHolder(@NonNull View view) {
        super(view);
        //Main - BookingTab - id signup
        try{
            ivCardImg = view.findViewById(R.id.bookingtab_rv_item_cardimg);
            saleTitle = view.findViewById(R.id.bookingtab_rv_item_saletitle);
            saleGuide = view.findViewById(R.id.bookingtab_rv_item_saleguide);
        }catch(Exception e){}
        //HotelSaleRVActivity - id signup
        try {
            hotelIv = view.findViewById(R.id.hotelsale_rv_item_iv);
            hotelNameTv = view.findViewById(R.id.hotelsale_rv_item_hotelname);
            cityNameTv = view.findViewById(R.id.hotelsale_rv_item_cityname);
            scheduleTv = view.findViewById(R.id.hotelsale_rv_item_schedule);
            hotelPriceTv = view.findViewById(R.id.hotelsale_rv_item_hotelprice);
            discountedRateTv = view.findViewById(R.id.hotelsale_rv_item_discountedrate);
        }catch(Exception e){}
    }
}
