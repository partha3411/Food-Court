package com.example.parthajavafinalproject.Sojib;

import javafx.scene.control.DatePicker;

public class MonitorTable {
    private String itemTable;
    private String thresholdTable;
    private DatePicker dateTable;
    private Integer qualityTable;

    public MonitorTable(String itemTable, String thresholdTable, DatePicker dateTable, Integer qualityTable) {
        this.itemTable = itemTable;
        this.thresholdTable = thresholdTable;
        this.dateTable = dateTable;
        this.qualityTable = qualityTable;
    }

    public String getItemTable() {
        return itemTable;
    }

    public void setItemTable(String itemTable) {
        this.itemTable = itemTable;
    }

    public String getThresholdTable() {
        return thresholdTable;
    }

    public void setThresholdTable(String thresholdTable) {
        this.thresholdTable = thresholdTable;
    }

    public DatePicker getDateTable() {
        return dateTable;
    }

    public void setDateTable(DatePicker dateTable) {
        this.dateTable = dateTable;
    }

    public Integer getQualityTable() {
        return qualityTable;
    }

    public void setQualityTable(Integer qualityTable) {
        this.qualityTable = qualityTable;
    }

    @Override
    public String toString() {
        return "MonitorTable{" +
                "itemTable='" + itemTable + '\'' +
                ", thresholdTable='" + thresholdTable + '\'' +
                ", dateTable=" + dateTable +
                ", qualityTable=" + qualityTable +
                '}';
    }
}
