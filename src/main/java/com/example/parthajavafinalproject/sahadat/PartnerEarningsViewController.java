package com.example.parthajavafinalproject.sahadat;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class PartnerEarningsViewController {
    @javafx.fxml.FXML
    private TableColumn orderIdColumn;
    @javafx.fxml.FXML
    private TableView earningsTable;
    @javafx.fxml.FXML
    private TableColumn amountColumn;
    @javafx.fxml.FXML
    private Button withdrawButton;
    @javafx.fxml.FXML
    private Label balanceLabel;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void withDrawButton(ActionEvent actionEvent) {
    }
}
