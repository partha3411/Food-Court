package com.example.parthajavafinalproject.Sojib;

import javafx.beans.property.*;
import java.time.LocalDate;

public class MonitoringModule {
    private final StringProperty department;
    private final StringProperty compliance;
    private final ObjectProperty<LocalDate> date;

    public MonitoringModule(String department, String compliance, LocalDate date) {
        this.department = new SimpleStringProperty(department);
        this.compliance = new SimpleStringProperty(compliance);
        this.date = new SimpleObjectProperty<>(date);
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public StringProperty complianceProperty() {
        return compliance;
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }
}
