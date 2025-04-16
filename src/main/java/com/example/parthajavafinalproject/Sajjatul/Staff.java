package com.example.parthajavafinalproject.Sajjatul;

import java.time.LocalDate;

public class Staff {
    private String staffType;
    private String name;
    private int nid;
    private LocalDate joiningDate;
    private int salary;

    public Staff(LocalDate joiningDate, String name, int nid, int salary, String staffType) {
        this.joiningDate = joiningDate;
        this.name = name;
        this.nid = nid;
        this.salary = salary;
        this.staffType = staffType;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "joiningDate=" + joiningDate +
                ", staffType='" + staffType + '\'' +
                ", name='" + name + '\'' +
                ", nid=" + nid +
                ", salary=" + salary +
                '}';
    }
}