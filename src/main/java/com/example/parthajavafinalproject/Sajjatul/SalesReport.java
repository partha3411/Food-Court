package com.example.parthajavafinalproject.Sajjatul;

public class SalesReport {
    private String term;
    private int totalSell;
    private int totalBuy;
    private int profit;
    private int loss;

    public SalesReport(int loss, int profit, String term, int totalBuy, int totalSell) {
        this.loss = loss;
        this.profit = profit;
        this.term = term;
        this.totalBuy = totalBuy;
        this.totalSell = totalSell;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getTotalBuy() {
        return totalBuy;
    }

    public void setTotalBuy(int totalBuy) {
        this.totalBuy = totalBuy;
    }

    public int getTotalSell() {
        return totalSell;
    }

    public void setTotalSell(int totalSell) {
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
