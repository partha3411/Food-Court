package com.example.parthajavafinalproject.sahadat;

import java.util.List;

public class Restaurant {
    private String name;
    private List<FoodItem> menu;

    public Restaurant(String name, List<FoodItem> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return name;
    }
}

