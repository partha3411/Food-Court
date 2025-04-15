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
import javafx.stage.Stage;

import java.io.IOException;

public class SalesReportController {

    @FXML
    private TableColumn<?, ?> buyCol;

    @FXML
    private TableColumn<?, ?> lossCol;

    @FXML
    private TableColumn<?, ?> profitCol;

    @FXML
    private TableColumn<?, ?> sellCol;

    @FXML
    private TableView<?> tableView;

    @FXML
    private ComboBox<?> termCB;

    @FXML
    private TableColumn<?, ?> termCol;

    @javafx.fxml.FXML
    public void initialize() {
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
    void reportButton(ActionEvent event) {

    }

}
