package com.soemoe.financetracker.models;

public class Income extends Transaction {
    //constructors
    public Income(double transactionAmount,String description) {
        super(transactionAmount, description);
    }

    //methods
    @Override
    public String getTransactionType(){
        return "INCOME";
    }
}
