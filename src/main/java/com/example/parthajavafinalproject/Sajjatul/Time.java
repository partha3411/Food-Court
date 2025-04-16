package com.example.parthajavafinalproject.Sajjatul;

public class Time {
    private String openingTime;
    private String closingTime;
    private String offDay;

    public Time(String closingTime, String offDay, String openingTime) {
        this.closingTime = closingTime;
        this.offDay = offDay;
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getOffDay() {
        return offDay;
    }

    public void setOffDay(String offDay) {
        this.offDay = offDay;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public String toString() {
        return "Time{" +
                "closingTime='" + closingTime + '\'' +
                ", openingTime='" + openingTime + '\'' +
                ", offDay='" + offDay + '\'' +
                '}';
    }
}