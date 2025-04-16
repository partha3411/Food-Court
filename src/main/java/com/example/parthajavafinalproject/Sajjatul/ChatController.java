package com.example.parthajavafinalproject.Sajjatul;

import com.example.parthajavafinalproject.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ChatController {

    @FXML
    private TableColumn<Chat, String> customerCol;

    @FXML
    private TextArea customerMessageTA;

    @FXML
    private TableColumn<Chat, String> managerCol;

    @FXML
    private TextArea managerMessageTA;

    @FXML
    private TableView<String> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        customerCol.setCellValueFactory(new PropertyValueFactory<>("customerMessage"));
        managerCol.setCellValueFactory(new PropertyValueFactory<>("managerMessage"));
    }

    private ArrayList<Chat> Chats = new ArrayList<>();

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

    @FXML
    void customerSendButton(ActionEvent event) {

    }

    @FXML
    public void managerSendButton(ActionEvent actionEvent) {
    }
}
