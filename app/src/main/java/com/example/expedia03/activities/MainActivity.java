package com.example.expedia03.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.NestedScrollView;
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
import com.example.expedia03.entities.SignUpData;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    static final int HOTELSALE_UNDER80000 = 15;
    static final int HOTELSALE_DAILY = 16;
    static final int HOTELSALE_DEADLINE = 17;
    static final int SIGNUP_REQUEST = 1;

    private TabLayout tabLayout;
    private TabLayout.Tab tab1, tab2, tab3;
    private NestedScrollView mScroll;

    private LinearLayout bookingContent;
    private LinearLayout bookingtab_signupView;
    private TextView bookingtab_pointGuideView;
    private Button bookingtab_signupBtn;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<HotelSaleData> dataList;

    private LinearLayout scheduleContent;
    private LinearLayout scheduletab_signupView;
    private LinearLayout scheduletab_schedulingView;
    private Button scheduletab_signupBtn;

    private LinearLayout accountContent;
    private LinearLayout accounttab_signupView;
    private LinearLayout accounttab_accountView;
    private TextView accounttab_tvName, accounttab_tvEmail;
    private Button accounttab_signupBtn, accounttab_logoutBtn;

    private SignUpData account;

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
        mScroll = findViewById(R.id.main_scroll);

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
        dataList.add(new HotelSaleData(HOTELSALE_UNDER80000,"￦80,000 이하 특가", "호텔이 1박에 ￦80,000 이하!", R.drawable.card1_img));
        dataList.add(new HotelSaleData(HOTELSALE_DAILY,"일일 특가", "매일 일부 호텔을 40%이상 할인해 드려요.매일 밤 자정 특가 상품이 업데이트 됩니다.", R.drawable.card3_img));
        dataList.add(new HotelSaleData(HOTELSALE_DEADLINE,"마감특가 상품", "훌쩍 떠나고 싶으세요? 마감 특가 상품을 확인해 보세요.", R.drawable.card4_img));
        BookingTabRVAdapter rvAdapter = new BookingTabRVAdapter(dataList);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(rvAdapter);

        //ScheduleTab Login/Logout - SignupView/SchedulingView
        scheduletab_signupView = findViewById(R.id.scheduletab_signup_view);
        scheduletab_schedulingView = findViewById(R.id.scheduletab_scheduling_view);
        scheduletab_signupBtn = findViewById(R.id.scheduletab_signup_btn);

        //AccountTab Login/Logout- SignupView/AccountView
        accounttab_signupView = findViewById(R.id.accounttab_signup_view);
        accounttab_accountView = findViewById(R.id.accounttab_account_view);
        accounttab_tvName = findViewById(R.id.accounttab_name_tv);
        accounttab_tvEmail = findViewById(R.id.accounttab_email_tv);
        accounttab_logoutBtn = findViewById(R.id.accounttab_logout_btn);
        accounttab_signupBtn = findViewById(R.id.accounttab_signup_btn);

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

        bookingtab_signupBtn.setOnClickListener(this);
        scheduletab_signupBtn.setOnClickListener(this);
        accounttab_signupBtn.setOnClickListener(this);
        accounttab_logoutBtn.setOnClickListener(this);


        mScroll.post(new Runnable() {
            @Override
            public void run() {
                mScroll.scrollTo(0,0);
            }
        });
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

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bookingtab_signup_btn:
            case R.id.scheduletab_signup_btn:
            case R.id.accounttab_signup_btn:
                Intent signUpIntent = new Intent(MainActivity.this, SignupActivity.class);
                startActivityForResult(signUpIntent, SIGNUP_REQUEST);
                break;
            case R.id.accounttab_logout_btn:
                loginProcess(false);
                bookingtab_signupView.setVisibility(View.VISIBLE);
                bookingtab_pointGuideView.setVisibility(View.GONE);

                scheduletab_signupView.setVisibility(View.GONE);
                scheduletab_schedulingView.setVisibility(View.VISIBLE);

                accounttab_signupView.setVisibility(View.VISIBLE);
                accounttab_accountView.setVisibility(View.GONE);
                accounttab_logoutBtn.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            switch(requestCode){
                case SIGNUP_REQUEST:
                    account = (SignUpData)data.getSerializableExtra("accountObj");
                    System.out.println("MainPage>>\nEmail: "+account.getEmail());
                    System.out.println("Pw: "+account.getPw());
                    System.out.println("Name: "+account.getName());
                    System.out.println("Token: "+account.getToken());
                    loginProcess(true);
            }
        }
    }

    private void loginProcess(Boolean isLogin){
        if(isLogin){// Login
            bookingtab_signupView.setVisibility(View.GONE);
            bookingtab_pointGuideView.setVisibility(View.VISIBLE);

            scheduletab_signupView.setVisibility(View.GONE);
            scheduletab_schedulingView.setVisibility(View.VISIBLE);

            //accounttab_tvName.setText(account.getName());
            accounttab_tvEmail.setText(account.getName());
            accounttab_signupView.setVisibility(View.GONE);
            accounttab_accountView.setVisibility(View.VISIBLE);
            accounttab_logoutBtn.setVisibility(View.VISIBLE);
        }else{//Logout
            bookingtab_signupView.setVisibility(View.VISIBLE);
            bookingtab_pointGuideView.setVisibility(View.GONE);

            scheduletab_signupView.setVisibility(View.GONE);
            scheduletab_schedulingView.setVisibility(View.VISIBLE);

            account = null;
            accounttab_signupView.setVisibility(View.VISIBLE);
            accounttab_accountView.setVisibility(View.GONE);
            accounttab_logoutBtn.setVisibility(View.GONE);
        }
    }
}
