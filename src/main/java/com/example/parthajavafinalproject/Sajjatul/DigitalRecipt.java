package com.example.parthajavafinalproject.Sajjatul;

import java.time.LocalDate;

public class DigitalRecipt {
    private String name;
    private String item;
    private int price;
    private LocalDate date;

    public DigitalRecipt(LocalDate date, String item, String name, int price) {
        this.date = date;
        this.item = item;
        this.name = name;
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DigitalRecipt{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", item='" + item + '\'' +
                ", price=" + price +
                '}';
    }
}
