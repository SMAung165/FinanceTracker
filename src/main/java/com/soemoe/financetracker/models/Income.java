package com.soemoe.financetracker.models;

public class Income extends Transaction {
    //constructors
    public Income(double amount, String description) {
        super(amount, new Category("test", "Just testing"), description);
    }
    public Income(double transactionAmount, Category category, String description) {
        super(transactionAmount, category, description);
    }
}
