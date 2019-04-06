package com.example.expedia03.entities;

public class HotelData {
    private String hotelName, cityName, schedule, hotelPrice, discountedRate;
    private int hotelImgRes;

    public HotelData(String hotelName, String cityName, String schedule, String hotelPrice, String discountedRate, int hotelImgRes) {
        this.hotelName = hotelName;
        this.cityName = cityName;
        this.schedule = schedule;
        this.hotelPrice = hotelPrice;
        this.discountedRate = discountedRate;
        this.hotelImgRes = hotelImgRes;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public String getDiscountedRate() {
        return discountedRate;
    }

    public void setDiscountedRate(String discountedRate) {
        this.discountedRate = discountedRate;
    }

    public int getHotelImgRes() {
        return hotelImgRes;
    }

    public void setHotelImgRes(int hotelImgRes) {
        this.hotelImgRes = hotelImgRes;
    }
}
