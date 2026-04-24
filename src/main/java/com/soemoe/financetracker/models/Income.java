package com.soemoe.financetracker.models;

public class Income extends Transaction {
    //constructors
    public Income(double transactionAmount,String description, Category category) {
        super(transactionAmount, description, category);
    }

    //methods
    @Override
    public String getTransactionType(){
        return "INCOME";
    }
}
