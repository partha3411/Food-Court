package com.example.parthajavafinalproject;

import java.io.Serializable;

public class CustomerCritic implements Serializable {
    private String phoneNumber;
    private String critic;

    public CustomerCritic(String phoneNumber, String critic) {
        this.phoneNumber = phoneNumber;
        this.critic = critic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCritic() {
        return critic;
    }
}

