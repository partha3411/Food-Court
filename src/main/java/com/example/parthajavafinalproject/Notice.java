package com.example.parthajavafinalproject;

import java.io.Serializable;

public class Notice implements Serializable {
    private String waiterName;
    private String message;

    public Notice(String waiterName, String message) {
        this.waiterName = waiterName;
        this.message = message;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Notice from " + waiterName + ": " + message;
    }
}
