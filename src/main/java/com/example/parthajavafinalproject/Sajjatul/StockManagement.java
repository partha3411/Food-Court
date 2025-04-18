package com.example.parthajavafinalproject.Sajjatul;

public class StockManagement {
    private String itemName;
    private int quantity;
    private int howLongLast;


    public StockManagement() {
    }

    public StockManagement(String howLongLast, int itemName, int quantity) {
        this.howLongLast = Integer.parseInt(howLongLast);
        this.itemName = String.valueOf(itemName);
        this.quantity = quantity;
    }

    public int getHowLongLast() {
        return howLongLast;
    }

    public void setHowLongLast(int howLongLast) {
        this.howLongLast = howLongLast;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StockManagement{" +
                "howLongLast=" + howLongLast +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}