package com.example.parthajavafinalproject.Sojib;

import javafx.beans.property.*;

import java.time.LocalDate;

public class FoodComplaint {
    private final ObjectProperty<LocalDate> date;
    private final StringProperty name;
    private final StringProperty comment;

    public FoodComplaint(LocalDate date, String name, String comment) {
        this.date = new SimpleObjectProperty<>(date);
        this.name = new SimpleStringProperty(name);
        this.comment = new SimpleStringProperty(comment);
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty commentProperty() {
        return comment;
    }
}
