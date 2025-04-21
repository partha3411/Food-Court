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

public class BillingStaffController {

    @FXML
    private TableColumn<BillingStaff, Double> amountCol;

    @FXML
    private TextField amountTF;

    @FXML
    private TableColumn<BillingStaff, String> categoryCol;

    @FXML
    private TableColumn<BillingStaff, LocalDate> dateCol;

    @FXML
    private DatePicker dateDP;

    @FXML
    private ComboBox<String> staffCB;

    @FXML
    private TableView<BillingStaff> tableView;

    @FXML
    private Label textLabel;

    @javafx.fxml.FXML
    public void initialize() {

        staffCB.getItems().addAll("Manager","Cleaner","Chef","Security","Waiter");

        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    private ArrayList<BillingStaff> billStaff = new ArrayList<>();


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
        String category = staffCB.getValue();
        LocalDate date = dateDP.getValue();
        int amount = Integer.parseInt(amountTF.getText());;

        if (category == null || date == null) {
            textLabel.setText("Please input all");
            return;
        }

        try {
            BillingStaff bill = new BillingStaff(amount,category,date);
            billStaff.add(bill);
            tableView.getItems().add(bill);


            staffCB.setValue(null);
            dateDP.setValue(null);
            amountTF.clear();
            textLabel.setText("Bill added ");
        } catch (NumberFormatException e) {
            textLabel.setText("Invalid ");
        }
    }


}
