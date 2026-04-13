package com.soemoe.financetracker.models;

public class Expense extends Transaction {
    //constructors
    public Expense(double amount) {
        super(amount, new Category("test", "Just testing"), "", "", "");
    }

    public Expense(double transactionAmount, Category category, String description, String transactionDate, String transactionTime) {
        super(transactionAmount, category, description, transactionDate, transactionTime);
    }
}
