package com.example.expedia03.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.expedia03.R;
import com.example.expedia03.adapter.HotelInfoFragAdapter;
import com.example.expedia03.adapter.ServiceIconRVAdapter;
import com.example.expedia03.entities.HotelData;


public class HotelInfoActivity extends BaseActivity {
    ViewPager viewPager;
    HotelInfoFragAdapter frgAdapter;
    RecyclerView rvServiceIcon;
    RecyclerView.LayoutManager mLayoutManager;

    HotelData hotelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelinfo);
        initApp();
    }

    @Override
    public void initApp() {
        viewPager = findViewById(R.id.hotelinfo_viewpager);
        frgAdapter = new HotelInfoFragAdapter(getSupportFragmentManager());
        int[] imgRes = {R.drawable.hotel_room1,R.drawable.hotel_room2,R.drawable.hotel_room3,R.drawable.hotel_room4,R.drawable.hotel_room5};
        for(int i = 0; i < 5; i++){
            HotelImgFragment imgFragment = new HotelImgFragment(imgRes[i]);
            frgAdapter.addItem(imgFragment);
        }
        viewPager.setAdapter(frgAdapter);
        //호텔이미지 더미데이터
        frgAdapter.notifyDataSetChanged();

//        rvServiceIcon.findViewById(R.id.hotelinfo_service_recyclerview);
//        ServiceIconRVAdapter serviceIconRVAdapter = new ServiceIconRVAdapter(hotelData.getServiceNmae());
//
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
//        rvServiceIcon.setHasFixedSize(true);
//        rvServiceIcon.setLayoutManager(mLayoutManager);
//        rvServiceIcon.setAdapter(serviceIconRVAdapter);

    }

}
