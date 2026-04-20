package com.soemoe.financetracker.services;

import com.soemoe.financetracker.models.Transaction;

import java.util.ArrayList;

public class Wallet {
    private double balance;
    private final ArrayList<Transaction> transactions;

    //constructor
    public Wallet(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    //getters
    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    //setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //methods
    public void addNewTransaction(Transaction transaction) {
       transactions.add(transaction);
    }
}
