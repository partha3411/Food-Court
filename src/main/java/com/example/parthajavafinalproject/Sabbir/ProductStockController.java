package com.example.parthajavafinalproject.Sabbir;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductStockController {

    @FXML
    private TableView<ProductStock> stockTable;

    @FXML
    private TableColumn<ProductStock, String> productNameColumn;

    @FXML
    private TableColumn<ProductStock, Integer> quantityColumn;

    @FXML
    public void initialize() {
        // Bind the table columns to the ProductStock properties
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // Populate the table with sample data
        stockTable.setItems(getStockData());
    }

    // Sample data to display in the table
    private ObservableList<ProductStock> getStockData() {
        return FXCollections.observableArrayList(
                new ProductStock("Bread", 100),
                new ProductStock("Milk", 60),
                new ProductStock("Butter", 25)
        );
    }
}

