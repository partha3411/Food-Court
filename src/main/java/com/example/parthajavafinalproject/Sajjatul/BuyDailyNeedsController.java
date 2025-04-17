package com.example.parthajavafinalproject.Sajjatul;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class BuyDailyNeedsController {

    @FXML
    private TableColumn<BuyDailyNeeds, String> nameCol;

    @FXML
    private TextField nameTF;

    @FXML
    private TableColumn<BuyDailyNeeds, Double> priceCol;

    @FXML
    private TextField priceTF;

    @FXML
    private TableColumn<BuyDailyNeeds, Integer> quantityCol;

    @FXML
    private TextField quantityTF;

    @FXML
    private TableView<BuyDailyNeeds> tableView;

    @FXML
    private TableColumn<BuyDailyNeeds, Double> totalCol;

    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));

    }

    private ArrayList<BuyDailyNeeds> needs = new ArrayList<>();

    @FXML
    void addButton(ActionEvent event) {
        String name = nameTF.getText();
        String priceText = priceTF.getText();
        String quantityText = quantityTF.getText();

        double price = Double.parseDouble(priceText);
        int quantity = Integer.parseInt(quantityText);
        double total = price * quantity;

        BuyDailyNeeds item = new BuyDailyNeeds(name, quantity, price, total);
        needs.add(item);

        tableView.getItems().add(item);
        nameTF.clear();
        priceTF.clear();
        quantityTF.clear();

    }


    @FXML
    void backMenuButton(ActionEvent event) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sajjatul/cashier.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cashier Dashboard");
        stage.show();

    }

}
