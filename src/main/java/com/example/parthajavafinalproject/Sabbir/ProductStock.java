package com.example.parthajavafinalproject.Sabbir;

public class ProductStock {
    private final String productName;
    private final int quantity;

    public ProductStock(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}
