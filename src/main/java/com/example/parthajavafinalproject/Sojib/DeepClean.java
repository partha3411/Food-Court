package com.example.parthajavafinalproject.Sojib;

import java.time.LocalDate;

public class DeepClean {
    private final LocalDate date;
    private final String report;

    public DeepClean(LocalDate date, String report) {
        this.date = date;
        this.report = report;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getReport() {
        return report;
    }
}
