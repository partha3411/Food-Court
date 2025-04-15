package com.example.parthajavafinalproject.Sajjatul;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateAppController {

    @FXML
    private ComboBox<?> foodNameCB;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> priceCol;

    @FXML
    private TextField priceTF;

    @FXML
    private TableColumn<?, ?> ratingCol;

    @FXML
    private ComboBox<?> ratingsCB;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> yerterdayCol;

    @FXML
    private TextField yesterdaySellTF;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @FXML
    void addToMenuButton(ActionEvent event) {

    }

    @FXML
    void backMenuButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sajjatul/manager.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manager Dashboard");
        stage.show();

    }

}
