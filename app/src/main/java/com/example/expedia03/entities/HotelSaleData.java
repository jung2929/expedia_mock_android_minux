package com.example.expedia03.entities;

public class HotelSaleData {
    int saleType;
    private String saleTite, saleGuide;
    private int cardImg;

    public HotelSaleData(int saleType, String saleTite, String saleGuide, int cardImg) {
        this.saleType = saleType;
        this.saleTite = saleTite;
        this.saleGuide = saleGuide;
        this.cardImg = cardImg;
    }
    public int getSaleType() {
        return saleType;
    }

    public void setSaleType(int saleType) {
        this.saleType = saleType;
    }
    public String getSaleTite() {
        return saleTite;
    }

    public void setSaleTite(String saleTite) {
        this.saleTite = saleTite;
    }

    public String getSaleGuide() {
        return saleGuide;
    }

    public void setSaleGuide(String saleGuide) {
        this.saleGuide = saleGuide;
    }

    public int getCardImg() {
        return cardImg;
    }

    public void setCardImg(int cardImg) {
        this.cardImg = cardImg;
    }
}
