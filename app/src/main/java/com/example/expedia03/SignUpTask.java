package com.example.expedia03;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.expedia03.activities.SignupActivity;
import com.example.expedia03.entities.SignUpJson;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SignUpTask extends AsyncTask<String, Void, String> {
    Context mContext;

    ProgressDialog dialog;
    static final int CON_TIMEOUT = 20;

    public SignUpTask(Context mContext) {
        this.mContext = mContext;
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
        try {
                /*JSONObject jsonObject = new JSONObject(s).getJSONObject("boxOfficeResult");
                JSONArray jarray = jsonObject.getJSONArray("dailyBoxOfficeList");
                for (int i = 0; i < jarray.length(); i++) {
                    JSONObject jObject = jarray.getJSONObject(i);
                    rank = jObject.optString("rank");
                    movieName = jObject.optString("movieNm");
                    openDate = jObject.optString("openDt");
                    audiAcc = jObject.optString("audiAcc");

                    movieRankDataList.add(new MovieData(rank, movieName, openDate, audiAcc));

                }
                if (movieRankDataList.get(0).rank.equals(""))
                    movieRankDataList.remove(0);
                for (int i = 0; i < movieRankDataList.size(); i++) {
                    MoviePosterPathTask moviePosterPathTask = new MoviePosterPathTask();
                    moviePosterPathTask.execute(accessKey_tmdb, movieRankDataList.get(i).name, Integer.toString(i));
                }*/
            dialog.dismiss();
            System.out.println("RESULT: "+s);
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    String loadManager(String type, String email, String pwd, String userName){
        try {
            SignUpJson signUpJson = null;
            if(type.equals("user")){
                signUpJson = new SignUpJson(email, pwd, userName);
            }else{
                signUpJson = new SignUpJson(email, pwd);
            }
            String urlStr = "http://www.kaca5.com/expedia/" + type;
            URL signupURL = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection)signupURL.openConnection();
            con.setConnectTimeout(CON_TIMEOUT * 1000);
            con.setReadTimeout(CON_TIMEOUT * 1000);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            con.setDoInput(true);
            OutputStream os = con.getOutputStream();
            Gson gson = new Gson();
            String body = gson.toJson(signUpJson);
            System.out.println("BODY: (GSON->JSON"+body);
            os.write(body.getBytes("euc-kr"));
            os.flush();
            os.close();

            BufferedReader br;
            if (con.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                System.out.println("성공");
            } else {
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