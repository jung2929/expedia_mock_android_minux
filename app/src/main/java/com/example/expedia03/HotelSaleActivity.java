package com.example.expedia03;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class HotelSaleActivity extends AppCompatActivity {
    static final int HOTELSALE_UNDER80000 = 15;
    static final int HOTELSALE_DAILY = 16;
    static final int HOTELSALE_DEADLINE = 17;

    NestedScrollView mScroll;
    ImageButton closeBtn;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    TextView pageNameTv;

    LinearLayout under80000Guide;
    LinearLayout dailyGuide;

    private ArrayList<HotelData> dataList;
    int pageSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelsale);
        initApp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initApp(){
        //Page Mode Set 80,000원이하특가/일일특가/마감특가
        closeBtn = findViewById(R.id.hotelsale_close_btn);
        pageNameTv = findViewById(R.id.hotelsale_pagename_tv);
        Intent pageSetIntent = getIntent();
        pageSet = pageSetIntent.getIntExtra("pageset", 0);

        under80000Guide = findViewById(R.id.hotelsale_under80000_guideview);
        dailyGuide = findViewById(R.id.hotelsale_daily_guideview);

        switch(pageSet){
            case HOTELSALE_UNDER80000:
                under80000Guide.setVisibility(View.VISIBLE);
                break;
            case HOTELSALE_DAILY:
                dailyGuide.setVisibility(View.VISIBLE);
                break;
            case HOTELSALE_DEADLINE:
                pageNameTv.setVisibility(View.VISIBLE);
                break;
        }

        mRecyclerView = findViewById(R.id.hotelsale_recyclerview);
        dataList = new ArrayList<>();
        RVAdapter rvAdapter = new RVAdapter(dataList);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(rvAdapter);


        dataList.add(new HotelData("호프 랜드 호텔 수쿰핏 46/1", "방콕, 태국", "4월 25일(목) ~ 4월 27일 (토)", "39,401", "75", R.drawable.card1_img));
        dataList.add(new HotelData("서귀포 칼 호텔", "서귀포, 한국", "6월 7일(금) ~ 6월 8일 (토)", "68,182", "75", R.drawable.card2_img));
        dataList.add(new HotelData("NRC 레지던스 수완나품", "방콕, 태국", "4월 25일(목) ~ 4월 27일 (토)", "20,501", "75", R.drawable.card3_img));
        dataList.add(new HotelData("로열 라타나꼬신 호텔", "방콕, 태국", "4월 25일(목) ~ 4월 27일 (토)", "34,141", "75", R.drawable.card4_img));
    }
}
