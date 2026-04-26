package com.soemoe.financetracker.services;

import com.soemoe.financetracker.models.Category;
import com.soemoe.financetracker.models.Transaction;

import java.util.ArrayList;

public class Wallet {
    private double balance;
    private final ArrayList<Transaction> transactions;
    private final ArrayList<Category> categories;

    //constructor
    public Wallet(ArrayList<Transaction> transactions, ArrayList<Category> categories) {
        this.transactions = transactions;
        this.categories = categories;
    }

    //getters
    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    //methods
    public void addNewTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public void addNewCategory(Category category){
        categories.add(category);
    }

    public void updateBalance(double amount){
        balance += amount;
    }
}
