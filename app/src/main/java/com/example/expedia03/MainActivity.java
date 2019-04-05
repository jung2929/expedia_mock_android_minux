package com.example.expedia03;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    static final int HOTELSALE_UNDER80000 = 15;
    static final int HOTELSALE_DAILY = 16;
    static final int HOTELSALE_DEADLINE = 17;

    TabLayout tabLayout;
    TabLayout.Tab tab1, tab2, tab3;

    LinearLayout bookingContent;
    LinearLayout bookingtab_signupView;
    Button signupBtn;
    ImageView cardIv01, cardIv02, cardIv03, cardIv04;
    CardView under80000Card, dailyCard, deadLineCard;

    LinearLayout scheduleContent;
    LinearLayout scheduletab_signupView;
    LinearLayout scheduletab_schedulingView;

    LinearLayout accountContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initApp();
    }


    @Override
    protected void onStart() {
        super.onStart();
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        under80000Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HotelSaleActivity.class);
                intent.putExtra("pageset", HOTELSALE_UNDER80000);
                startActivity(intent);
            }
        });
        dailyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HotelSaleActivity.class);
                intent.putExtra("pageset", HOTELSALE_DAILY);
                startActivity(intent);
            }
        });
        deadLineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HotelSaleActivity.class);
                intent.putExtra("pageset", HOTELSALE_DEADLINE);
                startActivity(intent);
            }
        });
    }

    private void initApp(){
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
        under80000Card = findViewById(R.id.bookingtab_under80000_card);
        dailyCard = findViewById(R.id.bookingtab_dailys_card);
        deadLineCard = findViewById(R.id.bookingtab_deadline_card);
        cardIv01 = findViewById(R.id.bookingtab_card_iv01);
        cardIv02 = findViewById(R.id.bookingtab_card_iv02);
        cardIv03 = findViewById(R.id.bookingtab_card_iv03);
        cardIv04 = findViewById(R.id.bookingtab_card_iv04);
        Glide.with(this).load(R.drawable.card1_img).into(cardIv01);
        Glide.with(this).load(R.drawable.card2_img).into(cardIv02);
        Glide.with(this).load(R.drawable.card3_img).into(cardIv03);
        Glide.with(this).load(R.drawable.card4_img).into(cardIv04);

        //BookingTab no Login - SignupView
        bookingtab_signupView = findViewById(R.id.bookingtab_signup_view);
        signupBtn = findViewById(R.id.bookingtab_signup_btn);

        //ScheduleTab no Login - SignupView
        scheduletab_signupView = findViewById(R.id.scheduletab_signup_view);
        scheduletab_schedulingView = findViewById(R.id.scheduletab_scheduling_view);
        scheduletab_signupView.setVisibility(View.VISIBLE);
        scheduletab_schedulingView.setVisibility(View.GONE);
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
