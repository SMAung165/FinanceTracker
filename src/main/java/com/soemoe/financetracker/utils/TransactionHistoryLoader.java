package com.soemoe.financetracker.utils;

import com.google.gson.Gson;
import com.soemoe.financetracker.models.Transaction;

import java.util.ArrayList;

public class TransactionHistoryLoader {
    private final ArrayList<String> transactionList = new ArrayList<>();
    private final Gson gson;

    //constructors
    public TransactionHistoryLoader(){
        gson = new Gson();
    }

    //getters
    public ArrayList<String> getTransactionList() {
        return transactionList;
    }

    //setters
    public void setTransactionList(Transaction transaction){
        transactionList.add(gson.toJson(transaction));
    }
}
