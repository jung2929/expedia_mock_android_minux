package com.example.expedia03;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.expedia03.activities.SignupActivity;
import com.example.expedia03.dialog.JoinFailDialog;
import com.example.expedia03.dialog.LoginFailDialog;
import com.example.expedia03.entities.SignUpData;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SignUpTask extends AsyncTask<String, Void, String> {
    Context mContext;
    SignUpData account;
    ProgressDialog dialog;
    static final int CON_TIMEOUT = 20;

    public SignUpTask(Context mContext, SignUpData account) {
        this.mContext = mContext;
        this.account = account;
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
        return loadManager(strings[0], strings[1], strings[2], strings[3]);
    }

    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {//로그인 처리
            if(!s.equals("")) {//로그인 성공
                System.out.println("<로그인---");
                Gson gson = new Gson();
                JSONObject jsonObj = new JSONObject(s);
                JSONObject jsonToken = jsonObj.getJSONObject("token");//회원가입은 token이 없어 에러발생
                //catch문으로
                JSONArray jarray = jsonObj.getJSONArray("result");
                account = gson.fromJson(jarray.getString(0), SignUpData.class);
                account.setToken(jsonToken.optString("jwt"));

                System.out.println("Email: " + account.getName());
                System.out.println("Token: " + account.getToken());
            }else{//로그인 실패
                LoginFailDialog loginDialog = new LoginFailDialog(mContext);
                loginDialog.show();
            }
        } catch (Exception e) {//회원가입 처리
            try {
                System.out.println("<회원가입---");
                Gson gson = new Gson();
                JSONObject jsonObj = new JSONObject(s);
                if(jsonObj.optInt("code", 0) == 502) {
                    JoinFailDialog joinDialog = new JoinFailDialog(mContext);
                    joinDialog.show();
                }else {
                    JSONArray jarray = jsonObj.getJSONArray("result");
                    account = gson.fromJson(jarray.getString(0), SignUpData.class);
                    SignUpTask loginTask = new SignUpTask(mContext, account);
                    loginTask.execute("login", account.getEmail(), account.getPw(), null);
                /*System.out.println("Email: "+ account.getEmail());
                System.out.println("Pw: "+ account.getPw());
                System.out.println("Name: "+ account.getName());*/
                }
            }catch (Exception joinError){
                System.out.println(joinError);
            }
        }finally {
            dialog.dismiss();
            System.out.println("RESULT: "+s);
        }
    }

    String loadManager(String type, String email, String pwd, String userName){
        try {
            SignUpData signUpJson = null;
            if(type.equals("user")){
                signUpJson = new SignUpData(email, pwd, userName);
            }else{
                signUpJson = new SignUpData(email, pwd);
            }
            String urlStr = "http://www.kaca5.com/expedia/" + type;
            URL signupURL = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection)signupURL.openConnection();
            con.setConnectTimeout(CON_TIMEOUT * 1000);
            con.setReadTimeout(CON_TIMEOUT * 1000);
            con.setRequestMethod("POST");
            //Header 설정
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            con.setDoInput(true);
            //Data Json으로 POST
            OutputStream os = con.getOutputStream();
            //Body 설정
            Gson gson = new Gson();
            String body = gson.toJson(signUpJson); //SigUpData(객체) -> Json(String)
            System.out.println("BODY: (GSON->JSON"+body);
            os.write(body.getBytes("euc-kr"));
            os.flush();
            os.close();
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