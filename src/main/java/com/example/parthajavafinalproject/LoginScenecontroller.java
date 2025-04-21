package com.example.parthajavafinalproject;

import com.example.parthajavafinalproject.Sajjatul.Cashier;
import com.example.parthajavafinalproject.Sajjatul.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;


public class LoginScenecontroller
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML
    private TextField passwordTextField;
    @javafx.fxml.FXML
    private Label erorLabel;
    @javafx.fxml.FXML
    private Label successLabel;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Manager","Cashier","Customer","Food Delivery partner","Product Supplier","Cleaning Stuff","Health and Safety Officers","Admin");

    }

    @Deprecated
    public void waiterLoginButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("waiterDashboard.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Waiter Dashboard");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String id = idTextField.getText();
        String password = passwordTextField.getText();
        String userType = userTypeComboBox.getValue();

        if (id.isEmpty() || password.isEmpty() || userType == null) {
            erorLabel.setText("Please fill all fields.");
            return;
        }

        FXMLLoader fxmlLoader = null;

        if (userType.equals("Manager")) {
            ArrayList<Manager> managers = manager() ;
            for (Manager manager : managers) {
                if (manager.getId() == Integer.parseInt(id) && Objects.equals(manager.getPassword(), password)) {
                    fxmlLoader = new FXMLLoader(getClass().getResource("Sajjatul/manager.fxml"));
                    successLabel.setText("Manager Login Successful");
                    break ;
                }
            }

        }

        else if (userType.equals("Cashier")) {
            ArrayList<Cashier> cashiers = cashier() ;
            for (Cashier cashier : cashiers) {
                if (cashier.getId() == Integer.parseInt(id) && Objects.equals(cashier.getPassword(), password)) {
                    fxmlLoader = new FXMLLoader(getClass().getResource("Sajjatul/cashier.fxml"));
                    successLabel.setText("Cashier Login Successful");
                    break ;
                }
            }

        }
        else if (userType.equals("Customer") && id.equals("3333") && password.equals("@3333")) {
            fxmlLoader = new FXMLLoader(getClass().getResource("sahadat/customerDashboard.fxml"));
            successLabel.setText("Customer Login Successful");
        }
        else if (userType.equals("Food Delivery partner") && id.equals("4444") && password.equals("@4444")) {
            fxmlLoader = new FXMLLoader(getClass().getResource("sahadat/partnerDashboard.fxml"));
            successLabel.setText("Food Delivery partner Login Successful");
        }
        else if (userType.equals("Cleaning Stuff") && id.equals("5555") && password.equals("5556")) {
            fxmlLoader = new FXMLLoader(getClass().getResource("Sojib/CleaningTasksController.fxml"));
            successLabel.setText("Cleaning Stuff Login Successful");
        }
        else if (userType.equals("Health and Safety Officers") && id.equals("6666") && password.equals("6667")) {
            fxmlLoader = new FXMLLoader(getClass().getResource("Sojib/HealthTaskBar.fxml"));
            successLabel.setText("Health and Safety Login Successful");
        }
        //else if (userType.equals("Staff_Category") && id.equals("ID(4 Digit)") && password.equals("pass(your wish)")) {
            //fxmlLoader = new FXMLLoader(getClass().getResource("(Je fxml Load korte chao).fxml"));
            //successLabel.setText("staff Category Login Successful")

        //}
        else if (userType.equals("Product Supplier") && id.equals("7777") && password.equals("7777")) {
            try {
                // Switch to the AddProduct scene
                SceneSwitcher.switchTo("Sabbir/ProductSupplierDashboard");
            } catch (IOException e) {
                // Show an error alert if the scene cannot be loaded
                showAlert("Error", "Failed to load  scene.");
                e.printStackTrace();
            }
        }
        else if (userType.equals("Admin") && id.equals("8888") && password.equals("8888")) {
            try {
                // Switch to the AddProduct scene
                SceneSwitcher.switchTo("Sabbir/AdminDashboard");
            } catch (IOException e) {
                // Show an error alert if the scene cannot be loaded
                showAlert("Error", "Failed to load  scene.");
                e.printStackTrace();
            }
        }

        else {
            erorLabel.setText("Invalid user ID & Passward");
            return;
        }

        try {
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(userType + " Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Deprecated
    public void chefLoginOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chefDashboardScene.fxml"));
            Parent root = fxmlLoader.load();
            Scene nextScene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Chef DashBoard");
            stage.setScene(nextScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace to help with debugging
        }


    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void createAccount(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sajjatul/createAccount.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Create Account");
        stage.show();
    }

    public ArrayList<Cashier> cashier() {
        ArrayList<Cashier> newCashier = new ArrayList<>() ;
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("cashierFile.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Cashier cashier;
            try{
                while(true){
                    cashier = (Cashier) ois.readObject();
                    newCashier.add(cashier) ;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("External Error: " + ex.getMessage());
        }
        finally {
            try {

                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        return newCashier;
    }

    public ArrayList<Manager> manager() {
        ArrayList<Manager> newManager = new ArrayList<>() ;
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("managerFile.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Manager manager;
            try{
                while(true){
                    manager = (Manager) ois.readObject();
                    newManager.add(manager) ;
                }
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println("External Error: " + ex.getMessage());
        }
        finally {
            try {

                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        return newManager;
    }
}