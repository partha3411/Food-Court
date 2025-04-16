package com.example.parthajavafinalproject.Sajjatul;

public class BestSell {
    private String itemName;
    private String message;

    public BestSell(String itemName, String message) {
        this.itemName = itemName;
        this.message = message;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BestSell{" +
                "itemName='" + itemName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
