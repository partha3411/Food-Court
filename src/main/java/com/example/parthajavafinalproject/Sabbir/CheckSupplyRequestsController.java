package com.example.parthajavafinalproject.Sabbir;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CheckSupplyRequestsController {

    @FXML
    private TableView<SupplyRequest> requestTable;
    @FXML
    private TableColumn<SupplyRequest, String> requestIdColumn;
    @FXML
    private TableColumn<SupplyRequest, String> productColumn;
    @FXML
    private TableColumn<SupplyRequest, Integer> quantityColumn;
    @FXML
    private TableColumn<SupplyRequest, String> statusColumn;

    @FXML
    public void initialize() {
        // Binding properties to columns using your SupplyRequest class
        requestIdColumn.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        productColumn.setCellValueFactory(new PropertyValueFactory<>("product"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Optional: Load sample data
        requestTable.setItems(getSampleData());
    }

    private ObservableList<SupplyRequest> getSampleData() {
        return FXCollections.observableArrayList(
                new SupplyRequest("REQ001", "Tomatoes", 20, "Pending"),
                new SupplyRequest("REQ002", "Onions", 35, "Delivered"),
                new SupplyRequest("REQ003", "Carrots", 15, "In Progress")
        );
    }
}

