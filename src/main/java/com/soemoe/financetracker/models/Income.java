package com.soemoe.financetracker.models;

public class Income extends Transaction {
    //constructors
    public Income(double amount) {
        super(amount, new Category("test", "Just testing"), "", "", "");
    }
    public Income(double transactionAmount, Category category, String description, String transactionDate, String transactionTime) {
        super(transactionAmount, category, description, transactionDate, transactionTime);
    }
}
