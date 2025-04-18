package com.example.parthajavafinalproject.Sojib;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HygieneConditionController {
    @javafx.fxml.FXML
    private RadioButton notstarted;
    @javafx.fxml.FXML
    private CheckBox floorcleaned;
    @javafx.fxml.FXML
    private RadioButton Done;
    @javafx.fxml.FXML
    private CheckBox mirrorwiped;
    @javafx.fxml.FXML
    private TableColumn<HygieneCondition, String> ZoneTable;
    @javafx.fxml.FXML
    private TableView<HygieneCondition> ShowTableView;
    @javafx.fxml.FXML
    private CheckBox tissue;
    @javafx.fxml.FXML
    private CheckBox handwash;
    @javafx.fxml.FXML
    private TableColumn<HygieneCondition, String> tasktable;
    @javafx.fxml.FXML
    private TableColumn<HygieneCondition, DatePicker> lastcleanedTable;
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
    private TableColumn<HygieneCondition, String> durationtable;
    @javafx.fxml.FXML
    private TitledPane zonec;
    @javafx.fxml.FXML
    private TableColumn<HygieneCondition, String> statustable;
    @javafx.fxml.FXML
    private TitledPane zoneb;
    @javafx.fxml.FXML
    private TitledPane zonea;

    @javafx.fxml.FXML
    public void initialize() {
        ZoneTable.setCellValueFactory(cellData -> cellData.getValue().zone());
        tasktable.setCellValueFactory(cellData -> cellData.getValue().task());
        statustable.setCellValueFactory(cellData -> cellData.getValue().status());
        durationtable.setCellValueFactory(cellData -> cellData.getValue().duration());
        lastcleanedTable.setCellValueFactory(cellData -> cellData.getValue().lastCleaned());
    }
    @FXML
    void backButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sojib/CleaningTasksController.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cleaner Dashboard");
        stage.show();

    }

    @javafx.fxml.FXML
    public void updateTable(ActionEvent actionEvent) {
        String zone = "Zone A";  // Example, you can dynamically assign
        String task = "Clean Toilet"; // Example task, modify accordingly
        String status = getStatus();
        String durationText = duration.getText();
        String lastCleaned = lastcleanedPicker.getValue().toString();

        HygieneCondition newEntry = new HygieneCondition(zone, task, status, durationText, lastCleaned);
        ShowTableView.getItems().add(newEntry);
    }

    private String getStatus() {
        if (Done.isSelected()) {
            return "Done";
        } else if (working.isSelected()) {
            return "Working";
        } else if (notstarted.isSelected()) {
            return "Not Started";
        }
        return "Unknown";
    }

    public TitledPane getZoneb() {
        return zoneb;
    }

    public void setZoneb(TitledPane zoneb) {
        this.zoneb = zoneb;
    }

    public TitledPane getZonea() {
        return zonea;
    }

    public void setZonea(TitledPane zonea) {
        this.zonea = zonea;
    }

    public TitledPane getZonec() {
        return zonec;
    }

    public void setZonec(TitledPane zonec) {
        this.zonec = zonec;
    }

    public TitledPane getZonee() {
        return zonee;
    }

    public void setZonee(TitledPane zonee) {
        this.zonee = zonee;
    }

    public TitledPane getZoned() {
        return zoned;
    }

    public void setZoned(TitledPane zoned) {
        this.zoned = zoned;
    }

    public CheckBox getHandwash() {
        return handwash;
    }

    public void setHandwash(CheckBox handwash) {
        this.handwash = handwash;
    }

    public CheckBox getTissue() {
        return tissue;
    }

    public void setTissue(CheckBox tissue) {
        this.tissue = tissue;
    }

    public CheckBox getMirrorwiped() {
        return mirrorwiped;
    }

    public void setMirrorwiped(CheckBox mirrorwiped) {
        this.mirrorwiped = mirrorwiped;
    }

    public CheckBox getFloorcleaned() {
        return floorcleaned;
    }

    public void setFloorcleaned(CheckBox floorcleaned) {
        this.floorcleaned = floorcleaned;
    }
}
