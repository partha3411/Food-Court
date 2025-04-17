package com.example.parthajavafinalproject.sahadat;

public class FoodItem {
    private String name;
    private double price;
    private boolean available;

    public FoodItem(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

