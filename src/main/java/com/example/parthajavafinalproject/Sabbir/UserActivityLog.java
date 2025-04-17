package com.example.parthajavafinalproject.Sabbir;

public class UserActivityLog {
    private final String timestamp;
    private final String action;

    public UserActivityLog(String timestamp, String action) {
        this.timestamp = timestamp;
        this.action = action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getAction() {
        return action;
    }
}
