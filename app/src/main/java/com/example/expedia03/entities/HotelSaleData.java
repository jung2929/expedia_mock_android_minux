package com.example.expedia03.entities;

public class HotelSaleData {
    private String saleTite, saleGuide;
    private int cardImg;

    public HotelSaleData(String saleTite, String saleGuide, int cardImg) {
        this.saleTite = saleTite;
        this.saleGuide = saleGuide;
        this.cardImg = cardImg;
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
