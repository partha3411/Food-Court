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
import java.util.Locale;

public class DiscountOfferController {

    @FXML
    private DatePicker dateDP;

    @FXML
    private TableColumn<DiscountOffer, Integer> discountCol;

    @FXML
    private TextField discountTF;

    @FXML
    private ComboBox<String> itemCB;

    @FXML
    private TableColumn<DiscountOffer, Double> itemCol;

    @FXML
    private TableColumn<DiscountOffer, String> nameCol;

    @FXML
    private TableColumn<DiscountOffer, LocalDate> offerCol;

    @FXML
    private TextField priceTF;

    @FXML
    private TableColumn<DiscountOffer, String> promoCol;

    @FXML
    private TextField promoTF;

    @FXML
    private TableView<DiscountOffer> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        itemCB.getItems().addAll("Pasta", "Tikka", "Pizza", "Burgers", "Sandwich","Hot Dog");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemCol.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        discountCol.setCellValueFactory(new PropertyValueFactory<>("discount"));
        offerCol.setCellValueFactory(new PropertyValueFactory<>("offerDate"));
        promoCol.setCellValueFactory(new PropertyValueFactory<>("promoCode"));
    }

    private ArrayList<DiscountOffer> Offers = new ArrayList<>();

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
    void createOfferButton(ActionEvent event) {

    }

}
