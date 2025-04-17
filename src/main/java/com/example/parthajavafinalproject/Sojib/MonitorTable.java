package com.example.parthajavafinalproject.Sojib;

import java.time.LocalDate;

public class MonitorTable {
    private String itemTable;
    private String thresholdTable;
    private Integer qualityTable;
    private LocalDate dateTable;

    public MonitorTable(String itemTable, String thresholdTable, Integer qualityTable, LocalDate dateTable) {
        this.itemTable = itemTable;
        this.thresholdTable = thresholdTable;
        this.qualityTable = qualityTable;
        this.dateTable = dateTable;
    }

    public String getItemTable() {
        return itemTable;
    }

    public String getThresholdTable() {
        return thresholdTable;
    }

    public Integer getQualityTable() {
        return qualityTable;
    }

    public LocalDate getDateTable() {
        return dateTable;
    }

    public void setItemTable(String itemTable) {
        this.itemTable = itemTable;
    }

    public void setThresholdTable(String thresholdTable) {
        this.thresholdTable = thresholdTable;
    }

    public void setDateTable(LocalDate dateTable) {
        this.dateTable = dateTable;
    }

    public void setQualityTable(Integer qualityTable) {
        this.qualityTable = qualityTable;
    }
}
