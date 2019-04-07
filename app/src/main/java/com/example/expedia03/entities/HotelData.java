package com.example.expedia03.entities;

import java.util.ArrayList;

public class HotelData {
    private String hotelName, cityName, schedule, discountedPrice, discountedRate, review, price;
    private int hotelImgRes;
    private int totalGrade, cleanGrade, comfortGrade, stateGrade;
    ArrayList<String> serviceNmae;

    public HotelData(String hotelName, String cityName, String schedule, String discountedPrice, String discountedRate, int hotelImgRes) {
        this.hotelName = hotelName;
        this.cityName = cityName;
        this.schedule = schedule;
        this.discountedPrice = discountedPrice;
        this.discountedRate = discountedRate;
        this.hotelImgRes = hotelImgRes;
    }

    public ArrayList<String> getServiceNmae() {
        return serviceNmae;
    }

    public void setServiceNmae(ArrayList<String> serviceNmae){
        this.serviceNmae = serviceNmae;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }


    public String getDiscountedRate() {
        return discountedRate;
    }

    public int getHotelImgRes() {
        return hotelImgRes;
    }

    public String getReview() {
        return review;
    }

    public String getPrice() {
        return price;
    }

    public int getTotalGrade() {
        return totalGrade;
    }

    public int getCleanGrade() {
        return cleanGrade;
    }

    public int getComfortGrade() {
        return comfortGrade;
    }

    public int getStateGrade() {
        return stateGrade;
    }
}
