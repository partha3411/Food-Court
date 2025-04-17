package com.example.parthajavafinalproject.Sojib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class RoutineSafetyController {

    @FXML
    private ListView<String> Description;
    @FXML
    private DatePicker DateofInspector;
    @FXML
    private TableColumn<RoutineSafety, String> nameTable;
    @FXML
    private TableColumn<RoutineSafety, LocalDate> dateTable;
    @FXML
    private TextField name;
    @FXML
    private TableColumn<RoutineSafety, String> desTable;
    @FXML
    private TableView<RoutineSafety> RoutineSafety;

    private final ObservableList<RoutineSafety> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Set up table columns
        dateTable.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getDate()));
        nameTable.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getInspectorName()));
        desTable.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDescription()));
        RoutineSafety.setItems(data);

        // Load default inspection descriptions
        Description.getItems().addAll(
                "Fire extinguisher check",
                "Exit routes clear",
                "First aid kits stocked",
                "Hazardous materials secured"
        );
    }

    @FXML
    public void SubmitButton() {
        LocalDate date = DateofInspector.getValue();
        String inspector = name.getText();
        String description = String.join(", ", Description.getSelectionModel().getSelectedItems());

        if (date == null || inspector.isEmpty() || description.isEmpty()) {
            showAlert();
            return;
        }

        RoutineSafety entry = new RoutineSafety(date, inspector, description);
        data.add(entry);

        DateofInspector.setValue(null);
        name.clear();
        Description.getSelectionModel().clearSelection();
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Form Incomplete");
        alert.setHeaderText(null);
        alert.setContentText("Please fill in all fields and select at least one description.");
        alert.showAndWait();
    }
}
