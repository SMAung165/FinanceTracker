package com.soemoe.financetracker.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Transaction {
    private final double transactionAmount;
    private final String description;
    private final String transactionDate;
    private final String transactionTime;

    //constructors
    public Transaction(double transactionAmount, String description) {
        this.transactionAmount = transactionAmount;
        this.description = description;
        this.transactionDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        this.transactionTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a", Locale.US));
    }

    //getters
    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String getDescription() {
        return description;
    }

    public abstract String getTransactionType();
}
