package com.example.parthajavafinalproject.Sojib;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class HygieneCondition {
    @javafx.fxml.FXML
    private RadioButton notstarted;
    @javafx.fxml.FXML
    private CheckBox floorcleaned;
    @javafx.fxml.FXML
    private RadioButton Done;
    @javafx.fxml.FXML
    private CheckBox mirrorwiped;
    @javafx.fxml.FXML
    private TableColumn<CleanTable, String> ZoneTable;
    @javafx.fxml.FXML
    private TableView<CleanTable> ShowTableView;
    @javafx.fxml.FXML
    private CheckBox tissue;
    @javafx.fxml.FXML
    private CheckBox handwash;
    @javafx.fxml.FXML
    private TableColumn<CleanTable, String> tasktable;
    @javafx.fxml.FXML
    private TableColumn<CleanTable, DatePicker> lastcleanedTable;
    @javafx.fxml.FXML
    private TextField duration;
    @javafx.fxml.FXML
    private DatePicker lastcleanedPicker;
    @javafx.fxml.FXML
    private TitledPane zonee;
    @javafx.fxml.FXML
    private TitledPane zoned;
    @javafx.fxml.FXML
    private RadioButton working;
    @javafx.fxml.FXML
    private CheckBox toiletCleaned;
    @javafx.fxml.FXML
    private TableColumn<CleanTable, String> durationtable;
    @javafx.fxml.FXML
    private TitledPane zonec;
    @javafx.fxml.FXML
    private TableColumn<CleanTable, String> statustable;
    @javafx.fxml.FXML
    private TitledPane zoneb;
    @javafx.fxml.FXML
    private TitledPane zonea;

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateTable(ActionEvent actionEvent) {
    }
}
