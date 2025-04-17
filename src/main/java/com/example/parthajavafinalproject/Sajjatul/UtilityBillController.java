package com.example.parthajavafinalproject.Sajjatul;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UtilityBillController {

    @FXML
    private TableColumn<UtilityBill, Double> amountCol;

    @FXML
    private TextField amountTF;

    @FXML
    private TableColumn<UtilityBill, LocalDate> dateCol;

    @FXML
    private DatePicker dateDP;

    @FXML
    private Label label;

    @FXML
    private TableColumn<UtilityBill, String> nameCol;

    @FXML
    private TableView<UtilityBill> tableView;

    @FXML
    private ComboBox<String> utilityNameCB;

    @javafx.fxml.FXML
    public void initialize() {
            utilityNameCB.getItems().addAll("Electricity", "Water", "Internet", "Gas");

            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    private ArrayList<UtilityBill> Bills = new ArrayList<>();

    @FXML
    void backMenuButton(ActionEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sajjatul/cashier.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cashier Dasboard");
        stage.show();

    }


    @FXML
    void payBillButton(ActionEvent event) {
        String name = utilityNameCB.getValue();
        String amountText = amountTF.getText();
        LocalDate date = dateDP.getValue();

        if (name == null || amountText.isEmpty() || date == null) {
            label.setText("Please input all");
            return;
        }


        double amount = Double.parseDouble(amountText);
        UtilityBill bill = new UtilityBill(amount, date, name);
        Bills.add(bill);
        tableView.getItems().add(bill);


        utilityNameCB.setValue(null);
        amountTF.clear();
        dateDP.setValue(null);
        label.setText("Bill paid successfully!");

    }


}
