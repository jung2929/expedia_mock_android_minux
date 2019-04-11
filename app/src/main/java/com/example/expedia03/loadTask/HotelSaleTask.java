package com.example.expedia03.loadTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.expedia03.R;
import com.example.expedia03.activities.HotelSaleActivity;
import com.example.expedia03.activities.SignupActivity;
import com.example.expedia03.dialog.JoinFailDialog;
import com.example.expedia03.dialog.LoginFailDialog;
import com.example.expedia03.entities.HotelData;
import com.example.expedia03.entities.SignUpData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HotelSaleTask extends AsyncTask<String, Void, String> {
    Context mContext;
    ProgressDialog dialog;
    static final int CON_TIMEOUT = 20;
    int[] dumiImg;

    public HotelSaleTask(Context mContext) {
        this.mContext = mContext;
        dumiImg = new int[]{R.drawable.card1_img, R.drawable.card2_img, R.drawable.card3_img,
        R.drawable.card4_img};
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(mContext);
        dialog.setMessage("로딩중입니다.");
        dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        return loadManager(strings[0]);
    }

    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        System.out.println("RESULT: "+s);
        try {
            System.out.println("HotelSaleTask>>Try - catch");
            JSONArray jarray = new JSONObject(s).getJSONArray("result");
            Gson gson = new Gson();
            HotelData hotelData;
            for(int i = 0; i < jarray.length(); i++)
                ((HotelSaleActivity)mContext).addData(gson.fromJson(jarray.getString(i), HotelData.class));
            dialog.dismiss();
            ((HotelSaleActivity)mContext).notifyDataChanged();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String loadManager(String type){
        try {
            String urlStr = "http://www.kaca5.com/expedia/" + type;
            URL signupURL = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection)signupURL.openConnection();
            con.setConnectTimeout(CON_TIMEOUT * 1000);
            con.setReadTimeout(CON_TIMEOUT * 1000);
            con.setRequestMethod("GET");
            //Header 설정
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoInput(true);
            //결과 받기
            BufferedReader br = null;
            if (con.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                System.out.println("성공");
            } else{
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                System.out.println("실패");
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            return response.toString();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}