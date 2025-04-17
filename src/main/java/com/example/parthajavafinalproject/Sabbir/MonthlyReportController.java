package com.example.parthajavafinalproject.Sabbir;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


public class MonthlyReportController {
    @FXML
    private NumberAxis yAxis;
    @FXML
    private Button generateButton;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private BarChart<String, Number> supplyBarChart;

    public NumberAxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(NumberAxis yAxis) {
        this.yAxis = yAxis;
    }

    public BarChart<String, Number> getSupplyBarChart() {
        return supplyBarChart;
    }

    public void setSupplyBarChart(BarChart<String, Number> supplyBarChart) {
        this.supplyBarChart = supplyBarChart;
    }

    public ComboBox<String> getMonthComboBox() {
        return monthComboBox;
    }

    public void setMonthComboBox(ComboBox<String> monthComboBox) {
        this.monthComboBox = monthComboBox;
    }

    public CategoryAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(CategoryAxis xAxis) {
        this.xAxis = xAxis;
    }

    public Button getGenerateButton() {
        return generateButton;
    }

    public void setGenerateButton(Button generateButton) {
        this.generateButton = generateButton;
    }
}
