package com.example.parthajavafinalproject.Sajjatul;

import java.time.LocalDate;

public class DiscountOffer {
    private String itemName;
    private double itemPrice;
    private int discount;
    private LocalDate offerDate;
    private String promoCode;

    public DiscountOffer(int discount, String itemName, double itemPrice, LocalDate offerDate, String promoCode) {
        this.discount = discount;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.offerDate = offerDate;
        this.promoCode = promoCode;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public LocalDate getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(LocalDate offerDate) {
        this.offerDate = offerDate;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    @Override
    public String toString() {
        return "DiscountOffer{" +
                "discount=" + discount +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", offerDate=" + offerDate +
                ", promoCode='" + promoCode + '\'' +
                '}';
    }
}
