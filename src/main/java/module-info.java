module com.example.parthajavafinalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parthajavafinalproject to javafx.fxml;
    exports com.example.parthajavafinalproject;
}