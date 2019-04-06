package com.example.expedia03.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.expedia03.R;

public class SignupActivity extends BaseActivity {
    TabLayout tabLayout;
    ImageButton backBtn;
    EditText emailAddressEt, passwordEt;
    Button loginBtn;
    TextView forgetPwdTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initApp();
    }

    @Override
    public void initApp(){
        tabLayout = findViewById(R.id.signup_tablayout);
        backBtn = findViewById(R.id.signup_back_btn);
        //loginTabContent
        emailAddressEt = findViewById(R.id.logintab_emailaddress_et);
        passwordEt = findViewById(R.id.logintab_password_et);
        loginBtn = findViewById(R.id.logintab_login_btn);
        forgetPwdTv = findViewById(R.id.logintab_forget_pwd_tv);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
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

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void changeTabContent(int pos){
        LinearLayout loginTabContent = findViewById(R.id.signup_login_tab);
        RelativeLayout joinTabContent = findViewById(R.id.signup_join_tab);

        switch (pos){
            case 0:
                loginTabContent.setVisibility(View.VISIBLE);
                joinTabContent.setVisibility(View.INVISIBLE);
                break;
            case 1:
                loginTabContent.setVisibility(View.INVISIBLE);
                joinTabContent.setVisibility(View.VISIBLE);
                break;
        }
    }
}
