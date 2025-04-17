package com.example.parthajavafinalproject.Sojib;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmergencyTraining {
    private final StringProperty name;
    private final StringProperty done;
    private final StringProperty chosen;

    public EmergencyTraining(String name, String done, String chosen) {
        this.name = new SimpleStringProperty(name);
        this.done = new SimpleStringProperty(done);
        this.chosen = new SimpleStringProperty(chosen);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty doneProperty() {
        return done;
    }

    public StringProperty chosenProperty() {
        return chosen;
    }

}
