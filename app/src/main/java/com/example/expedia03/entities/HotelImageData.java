package com.example.expedia03.entities;

public class HotelImageData {
    private String HURL;
    private int dumiImgRes;

    public HotelImageData(String HURL) {
        this.HURL = HURL;
    }

    public String getHURL() {
        return HURL;
    }

    public void setImgRes(int imgRes){
        dumiImgRes = imgRes;
    }

    public int getImgRes(){
        return dumiImgRes;
    }
}
