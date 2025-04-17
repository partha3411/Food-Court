package com.example.parthajavafinalproject.Sojib;

public class CleaningRecord {
    private String date;
    private String area;
    private String person;
    private String task;

    public CleaningRecord(String date, String area, String person, String task) {
        this.date = date;
        this.area = area;
        this.person = person;
        this.task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "CleaningRecord{" +
                "date='" + date + '\'' +
                ", area='" + area + '\'' +
                ", person='" + person + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}
