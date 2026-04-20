package com.soemoe.financetracker.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import com.soemoe.financetracker.models.Expense;
import com.soemoe.financetracker.models.Income;
import com.soemoe.financetracker.models.Transaction;

public class JsonBuilder {
    public Gson build() {
        RuntimeTypeAdapterFactory<Transaction> adapter = RuntimeTypeAdapterFactory.of(Transaction.class, "type")
                .registerSubtype(Income.class, "Income")
                .registerSubtype(Expense.class, "Expense");

        return new GsonBuilder().registerTypeAdapterFactory(adapter).create();
    }
}
