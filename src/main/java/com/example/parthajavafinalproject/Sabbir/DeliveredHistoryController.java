package com.example.parthajavafinalproject.Sabbir;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DeliveredHistoryController {

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

    public DeliveredHistoryController(TableView<SupplyRequest> requestTable, TableColumn<SupplyRequest, String> requestIdColumn) {
        this.requestTable = requestTable;
        this.requestIdColumn = requestIdColumn;
    }

    @FXML
    public void initialize() {
        requestIdColumn.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        productColumn.setCellValueFactory(new PropertyValueFactory<>("product"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        requestTable.setItems(fetchRequests());
    }

    private ObservableList<SupplyRequest> fetchRequests() {
        return FXCollections.observableArrayList(
                new SupplyRequest("SR001", "Product A", 10, "Pending"),
                new SupplyRequest("SR002", "Product B", 20, "Delivered"),
                new SupplyRequest("SR003", "Product C", 15, "In Progress")
        );
    }
}
