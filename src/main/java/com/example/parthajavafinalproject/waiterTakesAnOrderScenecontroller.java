package com.example.parthajavafinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class waiterTakesAnOrderScenecontroller
{
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TextArea orderDetailsTextArea;
    @javafx.fxml.FXML
    private TextField nametextField;
    @javafx.fxml.FXML
    private TextField tableNumberTextField;

    ArrayList<Order>newOrderArraylist=new ArrayList<>();
    @javafx.fxml.FXML
    private Label updateLabel;
    @javafx.fxml.FXML
    private ComboBox<String> orderStatusComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        orderStatusComboBox.getItems().addAll("Pending","BeingPrepared","Ready","Canceled");
    }

    @javafx.fxml.FXML
    public void confirmButtonOnAction(ActionEvent actionEvent) {
        String name = nametextField.getText();
        String phone = phoneNumberTextField.getText();
        String table = tableNumberTextField.getText();
        String orderDetails = orderDetailsTextArea.getText();
        String orderstatus=orderStatusComboBox.getValue();

        Order newOrder = new Order(name, phone, table, orderDetails,orderstatus);
        newOrderArraylist.add(newOrder);
        saveNewOrderArraylistToFile();
        updateLabel.setText("Order is saved ");

    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("waiterDashboard.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("waiterDashboard");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace to help with debugging
        }


    }

    private void saveNewOrderArraylistToFile() {
        try {
            File f = new File("Order.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new ObjectOutputStream(fos) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            for (Order O : newOrderArraylist) {
                oos.writeObject(O);
            }
            oos.close();
            fos.close();
            updateLabel.setText(" order has been confirmed and is saved in the company DataBase, ");
        } catch (Exception e) {
            //
        }
    }


    }
