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
    private TableView<Chat> tableView;

    @javafx.fxml.FXML
    public void initialize() {
        customerCol.setCellValueFactory(new PropertyValueFactory<>("customerMessage"));
        managerCol.setCellValueFactory(new PropertyValueFactory<>("managerMessage"));
    }

    private ArrayList<String> chats = new ArrayList<String>();

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
        String cutomerMessage = customerMessageTA.getText().trim();
        if (!cutomerMessage.isEmpty()) {
            Chat chat = new Chat(cutomerMessage, "");
            tableView.getItems().add(chat);
            customerMessageTA.clear();
        }
    }

    @FXML
    public void managerSendButton(ActionEvent actionEvent) {
        String managerMessage = customerMessageTA.getText().trim();
        if (!managerMessage.isEmpty()) {
            Chat chat = new Chat("", managerMessage);
            chats .add(managerMessage);
            managerMessageTA.clear();
        }

    }
}
