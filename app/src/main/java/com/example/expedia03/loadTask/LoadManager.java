package com.example.expedia03.loadTask;

import com.example.expedia03.entities.SignUpData;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadManager {
    static final int CON_TIMEOUT = 20;
    String urlType, method;

    protected LoadManager(String urlType, String method){
        this.urlType = urlType;
        this.method = method;
    }

    protected String loadManager(String email, String pwd, String userName){
        try {
            SignUpData signUpJson = null;
            if(urlType.equals("user")){
                signUpJson = new SignUpData(email, pwd, userName);
            }else{
                signUpJson = new SignUpData(email, pwd);
            }
            String urlStr = "http://www.kaca5.com/expedia/" + urlType;
            URL signupURL = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection)signupURL.openConnection();
            con.setConnectTimeout(CON_TIMEOUT * 1000);
            con.setReadTimeout(CON_TIMEOUT * 1000);
            con.setRequestMethod(method);
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
