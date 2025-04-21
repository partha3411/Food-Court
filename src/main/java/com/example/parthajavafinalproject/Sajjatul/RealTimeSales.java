package com.example.parthajavafinalproject.Sajjatul;

import java.io.Serializable;

public class RealTimeSales implements Serializable {
    private String itemName;
    private int remainQuantity;

    public RealTimeSales(String itemName, int remainQuantity) {
        this.itemName = itemName;
        this.remainQuantity = remainQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(int remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    @Override
    public String toString() {
        return "RealTimeSales{" +
                "itemName='" + itemName + '\'' +
                ", remainQuantity=" + remainQuantity +
                '}';
    }
}