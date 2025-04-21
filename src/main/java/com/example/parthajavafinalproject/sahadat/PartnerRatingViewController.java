package com.example.parthajavafinalproject.sahadat;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PartnerRatingViewController {

    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    private ComboBox<Integer> cB1;

    @javafx.fxml.FXML
    private ComboBox<Integer> cB2;
    @javafx.fxml.FXML
    private Label label1;

    @javafx.fxml.FXML
    public void initialize() {

        for (int i = 1; i <= 5; i++) {
            cB1.getItems().add(i);
            cB2.getItems().add(i);
        }

        cB1.setPromptText("Select rating 1");
        cB2.setPromptText("Select rating 2");
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        Integer rating1 = cB1.getValue();
        Integer rating2 = cB2.getValue();

        if (rating1 != null && rating2 != null) {
            label.setText("Rating submitted: " + rating1 + " and " + rating2);
        } else {
            label.setText("Please select both ratings.");
        }
    }

    @javafx.fxml.FXML
    public void partnerDashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sahadat/partnerDashboard.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Back");
        stage.show();
    }
}
