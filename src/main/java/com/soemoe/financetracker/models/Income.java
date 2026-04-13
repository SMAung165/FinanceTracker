package com.soemoe.financetracker.models;

public class Income extends Transactions{
    //constructors
    public Income(String transactionDate, String transactionTime, double transactionAmount, String description, Category category) {
        super(transactionDate, transactionTime, transactionAmount, description, category);
    }
}
