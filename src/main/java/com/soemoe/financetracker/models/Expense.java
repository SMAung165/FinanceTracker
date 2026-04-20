package com.soemoe.financetracker.models;

public class Expense extends Transaction {
    //constructors
    public Expense(double transactionAmount, String description) {
        super(transactionAmount, description);
    }

    //methods
    @Override
    public String getTransactionType() {
        return "EXPENSE";
    }
}
