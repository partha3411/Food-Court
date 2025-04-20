package com.example.parthajavafinalproject.Sajjatul;

import java.time.LocalDate;

public class BillingStaff {
    private String category;
    private int amount;
    private LocalDate date;

    public BillingStaff(int amount, String category, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BillingStaff{" +
                "amount=" + amount +
                ", category='" + category + '\'' +
                ", date=" + date +
                '}';
    }
}