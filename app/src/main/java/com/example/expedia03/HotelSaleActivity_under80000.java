package com.example.expedia03;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class HotelSaleActivity_under80000 extends AppCompatActivity {
    ImageButton closeBtn;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<HotelData> dataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelsale_under80000);
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
        mRecyclerView = findViewById(R.id.under80000_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        dataList = new ArrayList<>();
        // String hotelName, cityName, schedule, hotelPrice, discountedRate, hotelImgUrl;
        dataList.add(new HotelData("호프 랜드 호텔 수쿰핏 46/1", "방콕, 태국", "4월 25일(목) ~ 4월 27일 (토)", "39,401", "75", R.drawable.card1_img));
        dataList.add(new HotelData("서귀포 칼 호텔", "서귀포, 한국", "6월 7일(금) ~ 6월 8일 (토)", "68,182", "75", R.drawable.card2_img));
        dataList.add(new HotelData("NRC 레지던스 수완나품", "방콕, 태국", "4월 25일(목) ~ 4월 27일 (토)", "20,501", "75", R.drawable.card3_img));
        dataList.add(new HotelData("로열 라타나꼬신 호텔", "방콕, 태국", "4월 25일(목) ~ 4월 27일 (토)", "34,141", "75", R.drawable.card4_img));
        RVAdapter rvAdapter = new RVAdapter(dataList);
        mRecyclerView.setAdapter(rvAdapter);

        closeBtn = findViewById(R.id.under80000_close_btn);
    }
}
