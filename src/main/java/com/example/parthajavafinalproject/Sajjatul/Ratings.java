package com.example.parthajavafinalproject.Sajjatul;

public class Ratings {
    private String customerName;
    private String foodName;
    private String rating;
    private String feedback;

    public Ratings(String customerName, String feedback, String foodName, String rating) {
        this.customerName = customerName;
        this.feedback = feedback;
        this.foodName = foodName;
        this.rating = rating;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "customerName='" + customerName + '\'' +
                ", foodName='" + foodName + '\'' +
                ", rating='" + rating + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
