package com.example.parthajavafinalproject.Sojib;

import javafx.beans.property.*;

import java.time.LocalDate;

public class MaintainModel {

    private final StringProperty problem;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty risk;


    public MaintainModel(String problem, LocalDate date, String risk) {
        this.problem = new SimpleStringProperty(problem);
        this.date = new SimpleObjectProperty<>(date);
        this.risk = new SimpleStringProperty(risk);
    }

    public StringProperty problemProperty() {
        return problem;
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public StringProperty riskProperty() {
        return risk;
    }

    public String getProblem() {
        return problem.get();
    }

    public LocalDate getDate() {
        return date.get();
    }

    public String getRisk() {
        return risk.get();
    }
}
