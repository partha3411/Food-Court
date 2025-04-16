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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SalesReportController {

    @FXML
    private TableColumn<SalesReport, Double> buyCol;

    @FXML
    private TableColumn<SalesReport, Double> lossCol;

    @FXML
    private TableColumn<SalesReport, Double> profitCol;

    @FXML
    private TableColumn<SalesReport, Double> sellCol;

    @FXML
    private TableView<SalesReport> tableView;

    @FXML
    private ComboBox<String> termCB;

    @FXML
    private TableColumn<SalesReport, String> termCol;

    @javafx.fxml.FXML
    public void initialize() {

        termCB.getItems().addAll("Daily","Weekly","Monthly","Yearly");


        termCol.setCellValueFactory(new PropertyValueFactory<>("term"));
        sellCol.setCellValueFactory(new PropertyValueFactory<>("totalSell"));
        buyCol.setCellValueFactory(new PropertyValueFactory<>("totalBuy"));
        profitCol.setCellValueFactory(new PropertyValueFactory<>("profit"));
        lossCol.setCellValueFactory(new PropertyValueFactory<>("loss"));
    }

    private ArrayList<SalesReport> dataPackageList=new ArrayList<>();

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
