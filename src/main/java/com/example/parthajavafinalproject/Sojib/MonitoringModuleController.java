package com.example.parthajavafinalproject.Sojib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class MonitoringModuleController {
    @FXML
    private TableColumn<MonitoringModule, String> depanametable;
    @FXML
    private DatePicker dateob;
    @FXML
    private TableColumn<MonitoringModule, LocalDate> dateChTable;
    @FXML
    private Label logOb;
    @FXML
    private TextField name;
    @FXML
    private TableView<MonitoringModule> MonitoringModule;
    @FXML
    private TableColumn<MonitoringModule, String> complainceTable;
    @FXML
    private ComboBox<String> depart;
    @FXML
    private TextArea viloationd;

    private final ObservableList<MonitoringModule> dataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize ComboBox with some department names
        depart.getItems().addAll("Warehouse", "Production", "Office", "Maintenance");
        depanametable.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
        complainceTable.setCellValueFactory(cellData -> cellData.getValue().complianceProperty());
        dateChTable.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        MonitoringModule.setItems(dataList);
    }

    @FXML
    public void submitv(ActionEvent actionEvent) {
        String officer = name.getText();
        LocalDate date = dateob.getValue();
        String dept = depart.getValue();
        String violation = viloationd.getText();

        if (officer.isEmpty() || date == null || dept == null || violation.isEmpty()) {
            logOb.setText("❌ Please complete all fields!");
            return;
        }
        MonitoringModule entry = new MonitoringModule(dept, violation, date);
        dataList.add(entry);
        logOb.setText("✅ Violation logged successfully!");
        name.clear();
        dateob.setValue(null);
        depart.getSelectionModel().clearSelection();
        viloationd.clear();
    }
}
