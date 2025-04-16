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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReceivePaymentController {

    @FXML
    private TableColumn<ReceivePayment, LocalDate> dateCol;

    @FXML
    private DatePicker dateDP;

    @FXML
    private DatePicker dateFilterDP;

    @FXML
    private ComboBox<String> paymentCB;

    @FXML
    private TableColumn<ReceivePayment, String> paymentCol;

    @FXML
    private TableColumn<ReceivePayment, Double> priceCol;

    @FXML
    private TextField priceTF;

    @FXML
    private TableView<String> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        paymentCB.getItems().addAll("Cash","Bkash","Nagad","Rocket","Upay","Card");

        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        paymentCol.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private ArrayList<ReceivePayment> Payments=new ArrayList<>();

    @FXML
    void addButton(ActionEvent event) {

    }

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
    void filterButton(ActionEvent event) {

    }

}
