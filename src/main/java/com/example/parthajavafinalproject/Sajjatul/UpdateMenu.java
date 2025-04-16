package com.example.parthajavafinalproject.Sajjatul;

public class UpdateMenu {
    private String name;
    private double price;
    private String rating;
    private int yesterdaySell;

    public UpdateMenu(String name, double price, String rating, int yesterdaySell) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.yesterdaySell = yesterdaySell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getYesterdaySell() {
        return yesterdaySell;
    }

    public void setYesterdaySell(int yesterdaySell) {
        this.yesterdaySell = yesterdaySell;
    }

    @Override
    public String toString() {
        return "UpdateMenu{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating='" + rating + '\'' +
                ", yesterdaySell=" + yesterdaySell +
                '}';
    }
}