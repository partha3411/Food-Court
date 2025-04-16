package com.example.parthajavafinalproject.Sajjatul;

import java.time.LocalDate;

public class StallManagement {
    private String stallName;
    private LocalDate billingDate;
    private LocalDate nextBillingDate;
    private String status;

    public StallManagement(LocalDate billingDate, LocalDate nextBillingDate, String stallName, String status) {
        this.billingDate = billingDate;
        this.nextBillingDate = nextBillingDate;
        this.stallName = stallName;
        this.status = status;
    }

    public StallManagement(String stall, LocalDate today, LocalDate nextBillingDate, String status) {

    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public LocalDate getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(LocalDate nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StallManagement{" +
                "billingDate=" + billingDate +
                ", stallName='" + stallName + '\'' +
                ", nextBillingDate=" + nextBillingDate +
                ", status='" + status + '\'' +
                '}';
    }
}