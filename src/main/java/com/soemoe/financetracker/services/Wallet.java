package com.soemoe.financetracker.services;

import com.soemoe.financetracker.models.Expense;
import com.soemoe.financetracker.models.Income;
import com.soemoe.financetracker.models.Transaction;

public class Wallet {
    private double balance;

    //constructor
    public Wallet() {
        balance = 0;
    }

    //getters
    public double getBalance() {
        return balance;
    }

    //methods
    public void processTransaction(Transaction transaction) {
        if (transaction instanceof Expense expense) {
            balance -= expense.getTransactionAmount();
        } else if (transaction instanceof Income income) {
            balance += income.getTransactionAmount();
        }
    }


}
