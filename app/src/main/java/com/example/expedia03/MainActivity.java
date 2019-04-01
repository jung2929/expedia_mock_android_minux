package com.example.expedia03;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabLayout.Tab tab1, tab2, tab3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        tab1 = tabLayout.newTab();
        tab1.setIcon(R.drawable.tab1_selected);
        tabLayout.addTab(tab1);
        tab2 = tabLayout.newTab();
        tab2.setIcon(R.drawable.tab2_unselected);
        tabLayout.addTab(tab2);
        tab3 = tabLayout.newTab();
        tab3.setIcon(R.drawable.tab3_unselected);
        tabLayout.addTab(tab3);

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
        FrameLayout tab1Content = findViewById(R.id.tab1_content);
        LinearLayout tab2Content = findViewById(R.id.tab2_content);
        LinearLayout tab3Content = findViewById(R.id.tab3_content);

        switch (pos){
            case 0:
                tab1Content.setVisibility(View.VISIBLE);
                tab2Content.setVisibility(View.INVISIBLE);
                tab3Content.setVisibility(View.INVISIBLE);
                tab1.setIcon(R.drawable.tab1_selected);
                tab2.setIcon(R.drawable.tab2_unselected);
                tab3.setIcon(R.drawable.tab3_unselected);
                break;
            case 1:
                tab1Content.setVisibility(View.INVISIBLE);
                tab2Content.setVisibility(View.VISIBLE);
                tab3Content.setVisibility(View.INVISIBLE);
                tab1.setIcon(R.drawable.tab1_unselected);
                tab2.setIcon(R.drawable.tab2_selected);
                tab3.setIcon(R.drawable.tab3_unselected);
                break;
            case 2:
                tab1Content.setVisibility(View.INVISIBLE);
                tab2Content.setVisibility(View.INVISIBLE);
                tab3Content.setVisibility(View.VISIBLE);
                tab1.setIcon(R.drawable.tab1_unselected);
                tab2.setIcon(R.drawable.tab2_unselected);
                tab3.setIcon(R.drawable.tab3_selected);
                break;
        }
    }
}
