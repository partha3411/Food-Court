package com.example.parthajavafinalproject.Sajjatul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class StallManagementController {

    @FXML
    private TableColumn<?, ?> billingDateColoumn;

    @FXML
    private ComboBox<?> durationComboBox;

    @FXML
    private Text label;

    @FXML
    private TableColumn<?, ?> nextBillingDateColoumn;

    @FXML
    private ComboBox<?> paymentComboBox;

    @FXML
    private ComboBox<?> stallComboBox;

    @FXML
    private TableColumn<?, ?> stallNameColoumn;

    @FXML
    private TableColumn<?, ?> statusColoumn;

    @FXML
    private TableView<?> tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    void confirmButton(ActionEvent event) {

    }

    @FXML
    void downloadReceiptButton(ActionEvent event) {

    }

    @FXML
    public void backMenuButton(ActionEvent actionEvent) {
    }
}
