package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class RevenueChartController {

    @FXML
    private ComboBox<String> periodComboBox;
    @FXML
    private PieChart revenuePieChart;
    @FXML
    private Button generateButton;

    public ComboBox<String> getPeriodComboBox() {
        return periodComboBox;
    }

    public void setPeriodComboBox(ComboBox<String> periodComboBox) {
        this.periodComboBox = periodComboBox;
    }

    public PieChart getRevenuePieChart() {
        return revenuePieChart;
    }

    public void setRevenuePieChart(PieChart revenuePieChart) {
        this.revenuePieChart = revenuePieChart;
    }

    public Button getGenerateButton() {
        return generateButton;
    }

    public void setGenerateButton(Button generateButton) {
        this.generateButton = generateButton;
    }
}
