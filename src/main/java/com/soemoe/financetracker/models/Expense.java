package com.soemoe.financetracker.models;

public class Expense extends Transaction {
    //constructors
    public Expense(double transactionAmount, String description,Category category) {
        super(transactionAmount, description, category);
    }

    //methods
    @Override
    public String getTransactionType() {
        return "EXPENSE";
    }
}
