package com.soemoe.financetracker.models;

public class Expense extends Transactions {
    //constructors
    public Expense(String transactionDate, String transactionTime, double transactionAmount, String description, Category category) {
        super(transactionDate, transactionTime, transactionAmount, description, category);
    }
}
