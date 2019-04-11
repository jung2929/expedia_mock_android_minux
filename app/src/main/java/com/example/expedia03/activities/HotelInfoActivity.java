package com.example.expedia03.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.expedia03.R;
import com.example.expedia03.adapter.HotelInfoFragAdapter;
import com.example.expedia03.adapter.ServiceIconRVAdapter;
import com.example.expedia03.entities.HotelData;


public class HotelInfoActivity extends BaseActivity implements View.OnClickListener{
    ViewPager viewPager;
    HotelInfoFragAdapter frgAdapter;
    TextView tvName, tvDiscountedPrice, tvPrice, tvSchedule, tvDiscountedRate;
    ImageButton closeBtn;
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
        hotelData = (HotelData)getIntent().getSerializableExtra("hotelData");
        //호텔 룸 뷰페이저 등록
        viewPager = findViewById(R.id.hotelinfo_viewpager);
        frgAdapter = new HotelInfoFragAdapter(getSupportFragmentManager());
        //호텔룸이미지 더미데이터
        int[] imgRes = {R.drawable.hotel_room1,R.drawable.hotel_room2,R.drawable.hotel_room3,R.drawable.hotel_room4,R.drawable.hotel_room5};
        for(int i = 0; i < 5; i++){
            HotelImgFragment imgFragment = new HotelImgFragment(imgRes[i]);
            frgAdapter.addItem(imgFragment);
        }
        viewPager.setAdapter(frgAdapter);
        frgAdapter.notifyDataSetChanged();

//        //정가 가격 설정
//        String str = hotelData.getPriced();
//        int commaIndex = str.indexOf(',');
//        String disPrice = str.substring(0, commaIndex) +  str.substring(commaIndex + 1);
//        int priceInt = Integer.parseInt(disPrice) / (1 - Integer.parseInt(hotelData.getPercentage()) * 0.01);
//        StringBuilder price = new StringBuilder(Integer.toString(priceInt));
//        price.setCharAt(price.length() - 3, ',');

        closeBtn = findViewById(R.id.hotelinfo_close_btn);
        tvName = findViewById(R.id.hotelinfo_name);
        tvPrice = findViewById(R.id.hotelinfo_price);
        tvDiscountedRate = findViewById(R.id.hotelinfo_discountedrate);
        tvDiscountedPrice = findViewById(R.id.hotelinfo_discountedprice);
        tvSchedule = findViewById(R.id.hotelinfo_schedule);

        tvName.setText(hotelData.getName());
        tvDiscountedRate.setText("-"+hotelData.getPercentage()+"%");
        tvDiscountedPrice.setText("￦"+hotelData.getPriced());
        tvSchedule.setText(hotelData.getSdate()+" ~ " + hotelData.getEdate());

        closeBtn.setOnClickListener(this);

//        rvServiceIcon.findViewById(R.id.hotelinfo_service_recyclerview);
//        ServiceIconRVAdapter serviceIconRVAdapter = new ServiceIconRVAdapter(hotelData.getServiceNmae());
//
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
//        rvServiceIcon.setHasFixedSize(true);
//        rvServiceIcon.setLayoutManager(mLayoutManager);
//        rvServiceIcon.setAdapter(serviceIconRVAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hotelinfo_close_btn:
                finish();
        }
    }
}
