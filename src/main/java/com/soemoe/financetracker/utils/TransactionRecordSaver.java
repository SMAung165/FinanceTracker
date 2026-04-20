package com.soemoe.financetracker.utils;

import com.google.gson.reflect.TypeToken;
import com.soemoe.financetracker.models.Transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TransactionRecordSaver {
    private final JsonBuilder jsonBuilder;
    //constructors
    public TransactionRecordSaver() {
        jsonBuilder = new JsonBuilder();
    }
    //methods
    public void saveTransactionRecord(ArrayList<Transaction> transactions) {
        try (FileWriter writer = new FileWriter("data/transactions.json")) {
            writer.write(jsonBuilder.build().toJson(transactions, new TypeToken<ArrayList<Transaction>>(){}.getType()));
        } catch (IOException e) {
            System.out.println("Error writing file!" + e);
        }
    }
}
