package com.soemoe.financetracker.models;

public abstract class Transactions {
    private String transactionDate;
    private String transactionTime;
    private double transactionAmount;
    private String description;
    private Category category;

    //constructors
    public Transactions(String transactionDate, String transactionTime, double transactionAmount, String description, Category category) {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.transactionAmount = transactionAmount;
        this.description = description;
        this.category = category;
    }
    //getters
    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }
}
