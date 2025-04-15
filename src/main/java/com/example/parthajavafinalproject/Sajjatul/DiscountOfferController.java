package com.example.parthajavafinalproject.Sajjatul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DiscountOfferController {

    @FXML
    private DatePicker dateDP;

    @FXML
    private TableColumn<?, ?> discountCol;

    @FXML
    private TextField discountTF;

    @FXML
    private ComboBox<?> itemCB;

    @FXML
    private TableColumn<?, ?> itemCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> offerCol;

    @FXML
    private TextField priceTF;

    @FXML
    private TableColumn<?, ?> promoCol;

    @FXML
    private TextField promoTF;

    @FXML
    private TableView<?> tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    void backMenuButton(ActionEvent event) {

    }

    @FXML
    void createOfferButton(ActionEvent event) {

    }

}
