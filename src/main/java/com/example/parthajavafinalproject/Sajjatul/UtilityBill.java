package com.example.parthajavafinalproject.Sajjatul;

import java.time.LocalDate;

public class UtilityBill {
    private String name;
    private double amount;
    private LocalDate date;

    public UtilityBill(double amount, LocalDate date, String name) {
        this.amount = amount;
        this.date = date;
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UtilityBill{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
