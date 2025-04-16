package com.example.parthajavafinalproject.Sojib;

import javafx.scene.control.*;

import java.time.LocalDate;

public class RestockCleanSupplyController
{
    @javafx.fxml.FXML
    private TextField ReorderItem;
    @javafx.fxml.FXML
    private DatePicker DateOfDeliver;
    @javafx.fxml.FXML
    private TableColumn<MonitorTable, String> thresholdTable;
    @javafx.fxml.FXML
    private TableColumn<MonitorTable, DatePicker> dateTable;
    @javafx.fxml.FXML
    private TableColumn<MonitorTable, String> itemTable;
    @javafx.fxml.FXML
    private TableColumn<MonitorTable, Integer> qualityTable;
    @javafx.fxml.FXML
    private Spinner<Integer> Quantity;
    @javafx.fxml.FXML
    private TableView<MonitorTable> MonitorTable;
    @javafx.fxml.FXML
    private TextField Threshold;

    @javafx.fxml.FXML

    public void initialize() {
        // Set up the Spinner with a range of 0 to 1000 and default value of 1
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 1);
        Quantity.setValueFactory(valueFactory);

        // Initialize table columns with cell value factories
        itemTable.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getItemTable()));
        thresholdTable.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getThresholdTable()));
        qualityTable.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getQualityTable()));
//      dateTable.setCellValueFactory(cellData -> new  javafx.beans.property.SimpleObjectProperty(cellData.getValue().getDateTable().toString()));

    }


    @javafx.fxml.FXML
    public void ReorderItemsButton() {
        String itemName = ReorderItem.getText();
        Integer quantity = Quantity.getValue();
        String threshold = Threshold.getText();
        LocalDate date = DateOfDeliver.getValue();

        if (itemName == null || itemName.isEmpty() || threshold == null || threshold.isEmpty() || date == null) {
            System.out.println("Please fill in all fields before adding.");
            return;
        }

        // Create a new MonitorTable row (ORDER IS CORRECT)
        MonitorTable newRow = new MonitorTable(itemName,threshold, quantity, date);

        // Add the row to the table
        MonitorTable.getItems().add(newRow);

        // Clear input fields
        ReorderItem.clear();
        Threshold.clear();
        Quantity.getValueFactory().setValue(1);
        DateOfDeliver.setValue(null);
    }


}