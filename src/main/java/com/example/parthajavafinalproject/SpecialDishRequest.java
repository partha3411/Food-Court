package com.example.parthajavafinalproject;

import java.io.Serializable;

public class SpecialDishRequest implements Serializable {
    private String name;
    private String phoneNumber;
    private String tableNumber;
    private String requestDetails;
    private String status;  // Added for tracking status

    public SpecialDishRequest(String name, String phoneNumber, String tableNumber, String requestDetails, String status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.tableNumber = tableNumber;
        this.requestDetails = requestDetails;
        this.status = status; // Initialize status
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public String getRequestDetails() {
        return requestDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
