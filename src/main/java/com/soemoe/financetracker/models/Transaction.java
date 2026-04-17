package com.soemoe.financetracker.models;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Transaction {
    private final double transactionAmount;
    private final Category category;
    private final String description;
    private final String transactionDate;
    private final String transactionTime;

    //constructors
    public Transaction(double transactionAmount, Category category, String description) {
        this.transactionAmount = transactionAmount;
        this.category = category;
        this.description = description;
        this.transactionDate = LocalDate.now().toString();
        this.transactionTime = LocalTime.now().toString();
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
