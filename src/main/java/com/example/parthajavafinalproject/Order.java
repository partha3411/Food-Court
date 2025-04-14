package com.example.parthajavafinalproject;

import java.io.Serializable;

public class Order implements Serializable {
    private String customerName;
    private String phoneNumber;
    private String tableNumber;
    public String orderDetails;
    public String orderStatus;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", tableNumber='" + tableNumber + '\'' +
                ", orderDetails='" + orderDetails + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

    public Order(String customerName, String phoneNumber, String tableNumber, String orderDetails, String orderStatus) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.tableNumber = tableNumber;
        this.orderDetails = orderDetails;
        this.orderStatus = orderStatus;


    }
}
