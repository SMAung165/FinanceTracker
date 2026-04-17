package com.soemoe.financetracker.models;

public class Expense extends Transaction {
    //constructors
    public Expense(double amount, String description) {
        super(amount, new Category("test", "Just testing"), description);
    }

    public Expense(double transactionAmount, Category category, String description) {
        super(transactionAmount, category, description);
    }
}
