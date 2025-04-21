package com.example.parthajavafinalproject.Sojib;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HealthCodeViolationController {
    @javafx.fxml.FXML
    private DatePicker cDate;
    @javafx.fxml.FXML
    private Label statusDONEorUNDONE;
    @javafx.fxml.FXML
    private TextField details;
    @javafx.fxml.FXML
    private ComboBox status;

    @javafx.fxml.FXML
    public void PDFdownload(ActionEvent actionEvent) {
    }

    @FXML
    void backButton(ActionEvent event)  throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sojib/HealthTaskBar.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Health Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void savedetails(ActionEvent actionEvent) {
    }
}
