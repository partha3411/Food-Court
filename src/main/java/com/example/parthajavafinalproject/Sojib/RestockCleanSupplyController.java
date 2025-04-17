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
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 1);
        Quantity.setValueFactory(valueFactory);
        itemTable.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getItemTable()));
        thresholdTable.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getThresholdTable()));
        qualityTable.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getQualityTable()));
//      dateTable.setCellValueFactory(cellData -> new  javafx.beans.property.SimpleObjectProperty(cellData.getValue().getDateTable().toString()));

    }
    @javafx.fxml.FXML
    public void ReorderItemsButton() {

    }


}