module com.example.parthajavafinalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parthajavafinalproject to javafx.fxml;
    opens com.example.parthajavafinalproject.Sajjatul to javafx.fxml;
    exports com.example.parthajavafinalproject;

    opens com.example.parthajavafinalproject.Sojib to javafx.fxml;
    exports com.example.parthajavafinalproject.Sojib;
}