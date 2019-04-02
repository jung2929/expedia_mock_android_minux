package com.example.expedia03;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabLayout.Tab tab1, tab2, tab3;
    Button signupBtn;
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
                Intent signupIntent = new Intent(MainActivity.this, SinupActivity.class);
                startActivity(signupIntent);
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

        //BookingTabContent
        signupBtn = findViewById(R.id.bookingtab_signup_btn);
    }

    private void changeTabContent(int pos){
        RelativeLayout bookingContent = findViewById(R.id.main_booking_content);
        LinearLayout scheduleContent = findViewById(R.id.main_schedule_content);
        LinearLayout accountContent = findViewById(R.id.main_account_content);

        switch (pos){
            case 0:
                bookingContent.setVisibility(View.VISIBLE);
                scheduleContent.setVisibility(View.INVISIBLE);
                accountContent.setVisibility(View.INVISIBLE);
                break;
            case 1:
                bookingContent.setVisibility(View.INVISIBLE);
                scheduleContent.setVisibility(View.VISIBLE);
                accountContent.setVisibility(View.INVISIBLE);
                break;
            case 2:
                bookingContent.setVisibility(View.INVISIBLE);
                scheduleContent.setVisibility(View.INVISIBLE);
                accountContent.setVisibility(View.VISIBLE);
                /*tab1.setIcon(R.drawable.tab1_unselected);
                tab2.setIcon(R.drawable.tab2_unselected);
                tab3.setIcon(R.drawable.tab3_selected);*/
                break;
        }
    }
}
