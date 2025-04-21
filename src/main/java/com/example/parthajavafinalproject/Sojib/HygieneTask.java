package com.example.parthajavafinalproject.Sojib;

public class HygieneTask {
    private final String zone;
    private final String task;
    private final String status;
    private final String duration;
    private final String lastCleaned;

    public HygieneTask(String zone, String task, String status, String duration, String lastCleaned) {
        this.zone = zone;
        this.task = task;
        this.status = status;
        this.duration = duration;
        this.lastCleaned = lastCleaned;
    }

    @Override
    public String toString() {
        return "HygieneTask{" +
                "zone='" + zone + '\'' +
                ", task='" + task + '\'' +
                ", status='" + status + '\'' +
                ", duration='" + duration + '\'' +
                ", lastCleaned='" + lastCleaned + '\'' +
                '}';
    }

    public String getZone() {
        return zone;
    }

    public String getTask() {
        return task;
    }

    public String getStatus() {
        return status;
    }

    public String getDuration() {
        return duration;
    }

    public String getLastCleaned() {
        return lastCleaned;
    }
}
