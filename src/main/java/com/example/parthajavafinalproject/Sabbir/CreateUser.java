package com.example.parthajavafinalproject.Sabbir;

import java.io.Serializable;

public class CreateUser implements Serializable {

    private String userId;
    private String name;
    private String password;
    private String email;
    private String role;
    private double salary;

    // Constructor
    public CreateUser(String userId, String name, String password, String email, String role, double salary) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.salary = salary;
    }

    // Getters and Setters for each field
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
