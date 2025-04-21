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

public class DigitalReciptController {

    @FXML
    private TableColumn<DigitalRecipt, LocalDate> dateCol;

    @FXML
    private DatePicker dateDP;

    @FXML
    private ComboBox<String> foodNameCB;

    @FXML
    private TableColumn<DigitalRecipt, String> itemCol;

    @FXML
    private TableColumn<DigitalRecipt, String> nameCol;

    @FXML
    private TextField nameTF;

    @FXML
    private TableColumn<DigitalRecipt, Double> priceCol;

    @FXML
    private TextField priceTF;

    @FXML
    private TableView<DigitalRecipt> tableView;

    @javafx.fxml.FXML
    public void initialize() {

        foodNameCB.getItems().addAll("Pasta", "Tikka", "Pizza", "Burgers", "Sandwich","Hot Dog");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemCol.setCellValueFactory(new PropertyValueFactory<>("item"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    private ArrayList<DigitalRecipt> recipts = new ArrayList<>();


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
    void downloadButton(ActionEvent event) {
        String customerName = nameTF.getText();
        String foodItem = foodNameCB.getValue();
        String price = priceTF.getText();
        LocalDate date = dateDP.getValue();

        if (customerName == null || customerName.isEmpty() ||
                foodItem == null || price.isEmpty() || date == null) {
            System.out.println("Please input all");
            return;
        }

        try {
            int priceItem = Integer.parseInt(price);

            DigitalRecipt recipt = new DigitalRecipt(date,foodItem,customerName, priceItem);
            recipts.add(recipt);
            tableView.getItems().add(recipt);

            nameTF.clear();
            foodNameCB.setValue(null);
            priceTF.clear();
            dateDP.setValue(null);

            System.out.println("Receipt downloaded");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
        }
    }


}
