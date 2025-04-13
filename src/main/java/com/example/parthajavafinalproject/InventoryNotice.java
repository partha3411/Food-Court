package com.example.parthajavafinalproject;

import java.io.Serializable;

public class InventoryNotice implements Serializable {
    private String message;

    public InventoryNotice(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

