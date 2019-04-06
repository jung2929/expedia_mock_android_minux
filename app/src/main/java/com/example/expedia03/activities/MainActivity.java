package com.example.expedia03.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.expedia03.R;
import com.example.expedia03.adapter.BookingTabRVAdapter;
import com.example.expedia03.entities.HotelSaleData;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    static final int HOTELSALE_UNDER80000 = 15;
    static final int HOTELSALE_DAILY = 16;
    static final int HOTELSALE_DEADLINE = 17;

    TabLayout tabLayout;
    TabLayout.Tab tab1, tab2, tab3;

    LinearLayout bookingContent;
    LinearLayout bookingtab_signupView;
    TextView bookingtab_pointGuideView;
    Button bookingtab_signupBtn;
    ImageView cardIv01, cardIv02, cardIv03, cardIv04;
    CardView under80000Card, dailyCard, deadLineCard;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<HotelSaleData> dataList;

    LinearLayout scheduleContent;
    LinearLayout scheduletab_signupView;
    LinearLayout scheduletab_schedulingView;

    LinearLayout accountContent;
    LinearLayout accounttab_signupView;
    LinearLayout accounttab_accountView;
    Button accounttab_logoutBtn;

    Boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initApp();
    }

    @Override
    public void initApp(){
        tabLayout = findViewById(R.id.main_tablayout);
        tab1 = tabLayout.getTabAt(0);
        tab2 = tabLayout.getTabAt(1);
        tab3 = tabLayout.getTabAt(2);
        tab1.setIcon(R.drawable.travel_booking_tab);
        tab1.setText("여행예약");
        tab2.setIcon(R.drawable.schedule_tab);
        tab2.setText("일정");
        tab3.setIcon(R.drawable.account_tab);
        tab3.setText("계정");

        bookingContent = findViewById(R.id.main_booking_content);
        scheduleContent = findViewById(R.id.main_schedule_content);
        accountContent = findViewById(R.id.main_account_content);

        //BookingTabContent
        //BookingTab Login/Logout - SignupView/PointGuideView
        bookingtab_signupView = findViewById(R.id.bookingtab_signup_view);
        bookingtab_signupBtn = findViewById(R.id.bookingtab_signup_btn);
        bookingtab_pointGuideView = findViewById(R.id.bookingtab_pointguide_tv);
        //BookingTab Rv Adapter Setting
        mRecyclerView = findViewById(R.id.bookingtab_recyclerview);
        dataList = new ArrayList<>();
        //더미 데이터 SET
        dataList.add(new HotelSaleData("￦80,000 이하 특가", "호텔이 1박에 ￦80,000 이하!", R.drawable.card1_img));
        dataList.add(new HotelSaleData("일일 특가", "매일 일부 호텔을 40%이상 할인해 드려요.매일 밤 자정 특가 상품이 업데이트 됩니다.", R.drawable.card3_img));
        dataList.add(new HotelSaleData("마감특가 상품", "훌쩍 떠나고 싶으세요? 마감 특가 상품을 확인해 보세요.", R.drawable.card4_img));
        BookingTabRVAdapter rvAdapter = new BookingTabRVAdapter(dataList);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(rvAdapter);

        //ScheduleTab Login/Logout - SignupView/SchedulingView
        scheduletab_signupView = findViewById(R.id.scheduletab_signup_view);
        scheduletab_schedulingView = findViewById(R.id.scheduletab_scheduling_view);


        //AccountTab Login/Logout- SignupView/AccountView
        accounttab_signupView = findViewById(R.id.accounttab_signup_view);
        accounttab_accountView = findViewById(R.id.accounttab_account_view);
        accounttab_logoutBtn = findViewById(R.id.accounttab_logout_btn);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                int pos = tab.getPosition();
                changeTabContent(pos);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        bookingtab_signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLogin = true;
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        accounttab_logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLogin = false;
                bookingtab_signupView.setVisibility(View.VISIBLE);
                bookingtab_pointGuideView.setVisibility(View.GONE);

                scheduletab_signupView.setVisibility(View.GONE);
                scheduletab_schedulingView.setVisibility(View.VISIBLE);

                accounttab_signupView.setVisibility(View.VISIBLE);
                accounttab_accountView.setVisibility(View.GONE);
                accounttab_logoutBtn.setVisibility(View.GONE);
            }
        });

        if(isLogin){// Login
            bookingtab_signupView.setVisibility(View.GONE);
            bookingtab_pointGuideView.setVisibility(View.VISIBLE);

            scheduletab_signupView.setVisibility(View.GONE);
            scheduletab_schedulingView.setVisibility(View.VISIBLE);

            accounttab_signupView.setVisibility(View.GONE);
            accounttab_accountView.setVisibility(View.VISIBLE);
            accounttab_logoutBtn.setVisibility(View.VISIBLE);
        }else{//Logout
            bookingtab_signupView.setVisibility(View.VISIBLE);
            bookingtab_pointGuideView.setVisibility(View.GONE);

            scheduletab_signupView.setVisibility(View.GONE);
            scheduletab_schedulingView.setVisibility(View.VISIBLE);

            accounttab_signupView.setVisibility(View.VISIBLE);
            accounttab_accountView.setVisibility(View.GONE);
            accounttab_logoutBtn.setVisibility(View.GONE);
        }
    }

    private void changeTabContent(int pos){
        switch (pos){
            case 0:
                bookingContent.setVisibility(View.VISIBLE);
                scheduleContent.setVisibility(View.GONE);
                accountContent.setVisibility(View.GONE);
                break;
            case 1:
                bookingContent.setVisibility(View.GONE);
                scheduleContent.setVisibility(View.VISIBLE);
                accountContent.setVisibility(View.GONE);
                break;
            case 2:
                bookingContent.setVisibility(View.GONE);
                scheduleContent.setVisibility(View.GONE);
                accountContent.setVisibility(View.VISIBLE);
                break;
        }
    }
}
