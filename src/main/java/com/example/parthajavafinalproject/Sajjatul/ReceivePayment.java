package com.example.parthajavafinalproject.Sajjatul;

import java.time.LocalDate;

public class ReceivePayment {
    private LocalDate date;
    private String paymentMethod;
    private int price;

    public ReceivePayment(LocalDate date, String paymentMethod, int price) {
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ReceivePayment{" +
                "date=" + date +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", price=" + price +
                '}';
    }
}