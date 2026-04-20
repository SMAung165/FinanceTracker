package com.soemoe.financetracker.utils;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.soemoe.financetracker.models.Transaction;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TransactionRecordLoader {
    private ArrayList<Transaction> transactionList;
    private final JsonBuilder jsonBuilder;

    //constructors
    public TransactionRecordLoader() {
        jsonBuilder = new JsonBuilder();
        setTransactionList();
    }

    //getters
    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    //setters
    private void setTransactionList() {
        try (FileReader fileReader = new FileReader("data/transactions.json")) {
            transactionList = jsonBuilder.build().fromJson(fileReader, new TypeToken<ArrayList<Transaction>>() {
            }.getType());
            if (transactionList == null) transactionList = new ArrayList<>();
        } catch (IOException | JsonSyntaxException e) {
            System.out.println("Error reading file!" + e);
        }
    }
}
