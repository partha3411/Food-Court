package com.example.parthajavafinalproject.Sajjatul;

import java.time.LocalDate;

public class ReceivePayment {
    private LocalDate date;
    private String paymentMethod;
    private double price;

    public ReceivePayment(LocalDate date, String paymentMethod, double price) {
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

    public void setPrice(double price) {
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