package com.example.parthajavafinalproject.Sojib;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;

public class HygieneCondition {
    private String zone;
    private String task;
    private String status;
    private String duration;
    private String lastCleaned;

    public HygieneCondition(String zone, String task, String status, String duration, String lastCleaned) {
        this.zone = zone;
        this.task = task;
        this.status = status;
        this.duration = duration;
        this.lastCleaned = lastCleaned;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLastCleaned() {
        return lastCleaned;
    }

    public void setLastCleaned(DatePicker lastCleaned) {
        this.lastCleaned = String.valueOf(lastCleaned);
    }

    @Override
    public String toString() {
        return "CleanTable{" +
                "zone='" + zone + '\'' +
                ", task='" + task + '\'' +
                ", status='" + status + '\'' +
                ", duration='" + duration + '\'' +
                ", lastCleaned=" + lastCleaned +
                '}';
    }

    public ObservableValue<String> zone() {
        return null;
    }

    public ObservableValue<DatePicker> lastCleaned() {
        return null;
    }

    public ObservableValue<String> duration() {
        return null;
    }

    public ObservableValue<String> status() {
        return null;
    }

    public ObservableValue<String> task() {
        return null;
    }
}
