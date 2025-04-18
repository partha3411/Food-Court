package com.example.parthajavafinalproject.Sojib;

import java.time.LocalDate;

public class RoutineSafety {
    private LocalDate date;
    private String inspectorName;
    private String description;

    public RoutineSafety(LocalDate date, String inspectorName, String description) {
        this.date = date;
        this.inspectorName = inspectorName;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public String getDescription() {
        return description;
    }
}
