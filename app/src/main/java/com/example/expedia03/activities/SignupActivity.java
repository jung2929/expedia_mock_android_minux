package com.example.expedia03.activities;

import android.content.Intent;
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
import com.example.expedia03.SignUpTask;
import com.example.expedia03.entities.SignUpData;

public class SignupActivity extends BaseActivity {
    private TabLayout tabLayout;
    private TabLayout.Tab loginTab, joinTab;
    private ImageButton backBtn;

    private EditText logintab_etEmail, logintab_etPwd;
    private Button loginBtn;
    private TextView forgetPwdTv;

    private EditText jointab_etEmail, jointab_etPwd, userFirstName, userLastName;
    private Button joinBtn;

    private SignUpData account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initApp();
    }

    @Override
    public void initApp(){
        tabLayout = findViewById(R.id.signup_tablayout);
        loginTab = tabLayout.getTabAt(0);
        joinTab = tabLayout.getTabAt(1);
        backBtn = findViewById(R.id.signup_back_btn);
        //loginTabContent
        logintab_etEmail = findViewById(R.id.logintab_emailaddress_et);
        logintab_etPwd = findViewById(R.id.logintab_password_et);
        loginBtn = findViewById(R.id.logintab_login_btn);
        forgetPwdTv = findViewById(R.id.logintab_forget_pwd_tv);
        //joinTabContent
        jointab_etEmail = findViewById(R.id.jointab_emailaddress_et);
        jointab_etPwd = findViewById(R.id.jointab_password_et);
        userFirstName = findViewById(R.id.jointab_firstname_et);
        userLastName = findViewById(R.id.jointab_lastname_et);
        joinBtn = findViewById(R.id.jointab_join_btn);

        account = new SignUpData();

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
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = logintab_etEmail.getText().toString();
                String pwd = logintab_etPwd.getText().toString();
                SignUpTask loginTask = new SignUpTask(SignupActivity.this);
                loginTask.execute("login", email, pwd, null);
            }
        });
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = jointab_etEmail.getText().toString();
                String pwd = jointab_etPwd.getText().toString();
                String userName = userFirstName.getText().toString()+" "+userLastName.getText().toString();
                SignUpTask joinTask = new SignUpTask(SignupActivity.this);
                joinTask.execute("user", email, pwd, userName);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void changeTabContent(int pos){
        LinearLayout loginTabContent = findViewById(R.id.signup_logintab_container);
        RelativeLayout joinTabContent = findViewById(R.id.signup_jointab_container);
        switch (pos){
            case 0:
                loginTabContent.setVisibility(View.VISIBLE);
                joinTabContent.setVisibility(View.GONE);
                break;
            case 1:
                loginTabContent.setVisibility(View.GONE);
                joinTabContent.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void setTab(int pos){
        switch (pos){
            case 0:
                loginTab.select();
                changeTabContent(pos);
                break;
            case 1:
                joinTab.select();
                changeTabContent(pos);
        }
    }

    public void setAccount(SignUpData account){
        this.account = account;
    }
    public void closeSignUpPage(){
        Intent resultIntent = new Intent(this, MainActivity.class);
        System.out.println("SignUpPage>>\nEmail: "+account.getEmail());
        System.out.println("Pw: "+account.getPw());
        System.out.println("Name: "+account.getName());
        System.out.println("Token: "+account.getToken());
        resultIntent.putExtra("accountObj", account);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
