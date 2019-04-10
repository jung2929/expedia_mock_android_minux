package com.example.expedia03.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.expedia03.R;
import com.example.expedia03.activities.SignupActivity;

public class JoinFailDialog extends Dialog implements View.OnClickListener{
    Context mContext;
    private TextView tvExistingAccountLogin, tvDifferentEmailJoin;

    public JoinFailDialog(Context mContext){
        super(mContext);
        this.mContext = (SignupActivity)mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_joinfail);
        tvExistingAccountLogin = findViewById(R.id.joinfail_existingaccount_login_tv);
        tvDifferentEmailJoin = findViewById(R.id.joinfail_differentemail_join_tv);
        tvExistingAccountLogin.setOnClickListener(this);
        tvDifferentEmailJoin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.joinfail_existingaccount_login_tv:
                dismiss();
                ((SignupActivity)mContext).setTab(0);
                break;
            case R.id.joinfail_differentemail_join_tv:
                dismiss();
                break;
        }
    }
}
