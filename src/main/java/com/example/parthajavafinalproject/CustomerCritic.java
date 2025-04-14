package com.example.parthajavafinalproject;

import java.io.Serializable;

public class CustomerCritic implements Serializable {
    private String name;
    private String phoneNumber;
    private String tableNumber;
    private String criticMessage;

    public CustomerCritic(String name, String phoneNumber, String tableNumber, String criticMessage) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.tableNumber = tableNumber;
        this.criticMessage = criticMessage;
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

    public String getCriticMessage() {
        return criticMessage;
    }

    @Override
    public String toString() {
        return "CustomerCritic{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", tableNumber='" + tableNumber + '\'' +
                ", criticMessage='" + criticMessage + '\'' +
                '}';
    }
}
