package com.example.parthajavafinalproject;



import java.io.Serializable;

public class SpecialDishRequest implements Serializable {
    private String name;
    private String phoneNumber;
    private String tableNumber;
    private String requestDetails;

    public SpecialDishRequest(String name, String phoneNumber, String tableNumber, String requestDetails) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.tableNumber = tableNumber;
        this.requestDetails = requestDetails;
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
}

