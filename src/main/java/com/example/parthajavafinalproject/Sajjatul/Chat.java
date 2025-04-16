package com.example.parthajavafinalproject.Sajjatul;

public class Chat {
    private String customerMessage;
    private String managerMessage;

    public Chat(String customerMessage, String managerMessage) {
        this.customerMessage = customerMessage;
        this.managerMessage = managerMessage;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

    public String getManagerMessage() {
        return managerMessage;
    }

    public void setManagerMessage(String managerMessage) {
        this.managerMessage = managerMessage;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "customerMessage='" + customerMessage + '\'' +
                ", managerMessage='" + managerMessage + '\'' +
                '}';
    }
}