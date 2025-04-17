package com.example.parthajavafinalproject.Sajjatul;

public class SalesReport {
    private String term;
    private double totalSell;
    private double totalBuy;
    private double profit;
    private double loss;

    public SalesReport(double loss, double profit, String term, double totalBuy, double totalSell) {
        this.loss = loss;
        this.profit = profit;
        this.term = term;
        this.totalBuy = totalBuy;
        this.totalSell = totalSell;
    }

    public SalesReport(String selectedTerm, double totalSell, double totalBuy, double profit, double loss) {
    }

    public double getLoss() {
        return loss;
    }

    public void setLoss(double loss) {
        this.loss = loss;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public double getTotalBuy() {
        return totalBuy;
    }

    public void setTotalBuy(double totalBuy) {
        this.totalBuy = totalBuy;
    }

    public double getTotalSell() {
        return totalSell;
    }

    public void setTotalSell(double totalSell) {
        this.totalSell = totalSell;
    }

    @Override
    public String toString() {
        return "SalesReport{" +
                "loss=" + loss +
                ", term='" + term + '\'' +
                ", totalSell=" + totalSell +
                ", totalBuy=" + totalBuy +
                ", profit=" + profit +
                '}';
    }
}
