package com.example.expedia03.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.expedia03.R;

@SuppressLint("ValidFragment")
public class HotelImgFragment extends Fragment {
    int imgRes;

    HotelImgFragment(int imgRes) {
        this.imgRes = imgRes;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotelinfo_img, container, false);
        ImageView ivHotel = view.findViewById(R.id.hotelinfo_frag_iv);
        Glide.with(this).load(imgRes).into(ivHotel);

        return view;
    }
}
