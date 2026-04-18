package com.soemoe.financetracker.services;

import com.soemoe.financetracker.models.Expense;
import com.soemoe.financetracker.models.Income;
import com.soemoe.financetracker.models.Transaction;
import com.soemoe.financetracker.utils.TransactionHistoryLoader;

import java.util.ArrayList;

public class FinanceService {
    private final Wallet wallet;
    private final TransactionHistoryLoader transactionHistoryLoader;

    //constructors
    public FinanceService() {
        wallet = new Wallet();
        transactionHistoryLoader = new TransactionHistoryLoader();
    }

    //getters
    public double getBalance() {
        return wallet.getBalance();
    }

    //methods
    public void processTransaction(Transaction transaction) {
        double balance = wallet.getBalance();
        if (transaction instanceof Expense expense) {
            balance -= expense.getTransactionAmount();
        } else if (transaction instanceof Income income) {
            balance += income.getTransactionAmount();
        }
        wallet.setBalance(balance);
        transactionHistoryLoader.setTransactionList(transaction);
    }

    public ArrayList<String> getTransactionHistory(){
        return transactionHistoryLoader.getTransactionList();
    }
}
