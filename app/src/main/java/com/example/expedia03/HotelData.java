package com.example.expedia03;

public class HotelData {
    String hotelName, cityName, schedule, hotelPrice, discountedRate;
    int hotelImgRes;

    public HotelData(String hotelName, String cityName, String schedule, String hotelPrice, String discountedRate, int hotelImgRes) {
        this.hotelName = hotelName;
        this.cityName = cityName;
        this.schedule = schedule;
        this.hotelPrice = hotelPrice;
        this.discountedRate = discountedRate;
        this.hotelImgRes = hotelImgRes;
    }
}
