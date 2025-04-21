package com.example.parthajavafinalproject.Sojib;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HygieneConditionController {

    @FXML private Button backButton;
    @FXML private Accordion zoneAccordion;
    @FXML private CheckBox toiletCleaned, mirrorwiped, tissue, floorcleaned, handwash;
    @FXML private TableView<HygieneTask> ShowTableView;
    @FXML private TableColumn<HygieneTask, String> ZoneTable;
    @FXML private TableColumn<HygieneTask, String> tasktable;
    @FXML private TableColumn<HygieneTask, String> statustable;
    @FXML private TableColumn<HygieneTask, String> durationtable;
    @FXML private TableColumn<HygieneTask, String> lastcleanedTable;
    @FXML private RadioButton Done, working, notstarted;
    @FXML private TextField duration;
    @FXML private DatePicker lastcleanedPicker;

    private ObservableList<HygieneTask> taskData = FXCollections.observableArrayList();

    @FXML
    private void backButton(MouseEvent event) {
        System.out.println("Back button clicked");
    }

    @FXML
    private void initialize() {
        ZoneTable.setCellValueFactory(new PropertyValueFactory<>("zone"));
        tasktable.setCellValueFactory(new PropertyValueFactory<>("task"));
        statustable.setCellValueFactory(new PropertyValueFactory<>("status"));
        durationtable.setCellValueFactory(new PropertyValueFactory<>("duration"));
        lastcleanedTable.setCellValueFactory(new PropertyValueFactory<>("lastCleaned"));
        ShowTableView.setItems(taskData);
    }

    @FXML
    private void updateTable() {
        String status = getSelectedStatus();
        String zone = getSelectedZone();
        String durationText = duration.getText();
        String lastCleaned = lastcleanedPicker.getValue() != null ? lastcleanedPicker.getValue().toString() : "";

        if (toiletCleaned.isSelected()) {
            taskData.add(new HygieneTask(zone, "Toilet Cleaned", status, durationText, lastCleaned));
        }
        if (mirrorwiped.isSelected()) {
            taskData.add(new HygieneTask(zone, "Mirror Wiped", status, durationText, lastCleaned));
        }
        if (tissue.isSelected()) {
            taskData.add(new HygieneTask(zone, "Tissue Paper Availability", status, durationText, lastCleaned));
        }
        if (floorcleaned.isSelected()) {
            taskData.add(new HygieneTask(zone, "Floor Cleaned", status, durationText, lastCleaned));
        }
        if (handwash.isSelected()) {
            taskData.add(new HygieneTask(zone, "HandWash Avail", status, durationText, lastCleaned));
        }
    }

    private String getSelectedStatus() {
        if (Done.isSelected()) return "Done";
        if (working.isSelected()) return "Working";
        if (notstarted.isSelected()) return "Not Started";
        return "";
    }

    private String getSelectedZone() {
        if (zoneAccordion.getExpandedPane() != null) {
            return zoneAccordion.getExpandedPane().getText();
        }
        return "";
    }
}
