package com.example.expedia03.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class HotelData implements Serializable {
    private String Name, ShortL, Sdate, Edate , Priced, Percentage,review, price;
    private int dumiImgRes;


    private HotelImageData Image;
    private int[] roomImgs;
    private int totalGrade, cleanGrade, comfortGrade, stateGrade;
    ArrayList<String> serviceName;

    public HotelData(String name, String shortL, String sdate, String edate, String priced, String percentage,int imgRes) {
        Name = name;
        ShortL = shortL;
        Sdate = sdate;
        Edate = edate;
        Priced = priced;
        Percentage = percentage;
        dumiImgRes = imgRes;

    }

    public HotelImageData getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    public String getShortL() {
        return ShortL;
    }


    public String getSdate() {
        return Sdate;
    }

    public String getEdate() {
        return Edate;
    }

    public String getPriced() {
        return Priced;
    }

    public String getPercentage() {
        return Percentage;
    }

    public int getDumiImgRes() {
        return dumiImgRes;
    }
}
