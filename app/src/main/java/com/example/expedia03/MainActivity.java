package com.example.expedia03;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabLayout.Tab tab1, tab2, tab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initApp();
    }

    private void initApp(){
        tabLayout = findViewById(R.id.tablayout);
        tab1 = tabLayout.getTabAt(0);
        tab2 = tabLayout.getTabAt(1);
        tab3 = tabLayout.getTabAt(2);
        tab1.setIcon(R.drawable.travel_booking_tab);
        tab1.setText("여행예약");
        tab2.setIcon(R.drawable.schedule_tab);
        tab2.setText("일정");
        tab3.setIcon(R.drawable.account_tab);
        tab3.setText("계정");
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

    private void changeTabContent(int pos){
        RelativeLayout tab1Content = findViewById(R.id.tab1_content);
        LinearLayout tab2Content = findViewById(R.id.tab2_content);
        LinearLayout tab3Content = findViewById(R.id.tab3_content);

        switch (pos){
            case 0:
                tab1Content.setVisibility(View.VISIBLE);
                tab2Content.setVisibility(View.INVISIBLE);
                tab3Content.setVisibility(View.INVISIBLE);
                break;
            case 1:
                tab1Content.setVisibility(View.INVISIBLE);
                tab2Content.setVisibility(View.VISIBLE);
                tab3Content.setVisibility(View.INVISIBLE);
                break;
            case 2:
                tab1Content.setVisibility(View.INVISIBLE);
                tab2Content.setVisibility(View.INVISIBLE);
                tab3Content.setVisibility(View.VISIBLE);
                /*tab1.setIcon(R.drawable.tab1_unselected);
                tab2.setIcon(R.drawable.tab2_unselected);
                tab3.setIcon(R.drawable.tab3_selected);*/
                break;
        }
    }
}
