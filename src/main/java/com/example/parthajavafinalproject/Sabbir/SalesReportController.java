package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class SalesReportController {

    @FXML
    private ComboBox<String> reportTypeComboBox;
    @FXML
    private Button generateButton;
    @FXML
    private TextArea reportArea;

    public TextArea getReportArea() {
        return reportArea;
    }

    public void setReportArea(TextArea reportArea) {
        this.reportArea = reportArea;
    }

    public Button getGenerateButton() {
        return generateButton;
    }

    public void setGenerateButton(Button generateButton) {
        this.generateButton = generateButton;
    }

    public ComboBox<String> getReportTypeComboBox() {
        return reportTypeComboBox;
    }

    public void setReportTypeComboBox(ComboBox<String> reportTypeComboBox) {
        this.reportTypeComboBox = reportTypeComboBox;
    }
}
