package com.soemoe.financetracker.services;

import com.soemoe.financetracker.models.Expense;
import com.soemoe.financetracker.models.Income;
import com.soemoe.financetracker.models.Transaction;
import com.soemoe.financetracker.utils.TransactionRecordLoader;
import com.soemoe.financetracker.utils.TransactionRecordSaver;

import java.util.ArrayList;

public class FinanceService {
    private final Wallet wallet;
    private final TransactionRecordSaver transactionRecordSaver;
    private final TransactionRecordLoader transactionRecordLoader;

    //constructors
    public FinanceService() {
        transactionRecordSaver = new TransactionRecordSaver();
        transactionRecordLoader = new TransactionRecordLoader();
        wallet = new Wallet(transactionRecordLoader.getTransactionList());
        wallet.setBalance(getCurrentBalance());
    }

    //getters
    public double getBalance() {
        return wallet.getBalance();
    }

    //methods
    private double getCurrentBalance() {
        double currentBalance = 0;
        for (Transaction transaction : transactionRecordLoader.getTransactionList()) {
            currentBalance += balanceCalculator(transaction);
        }
        return currentBalance;
    }

    public void processTransaction(Transaction transaction) {
        double balance = balanceCalculator(transaction);
        wallet.setBalance(balance);
        wallet.addNewTransaction(transaction);
        transactionRecordSaver.saveTransactionRecord(wallet.getTransactions());
    }

    private double balanceCalculator(Transaction transaction) {
        double balance = wallet.getBalance();
        if (transaction instanceof Expense expense) {
            balance -= expense.getTransactionAmount();
        } else if (transaction instanceof Income income) {
            balance += income.getTransactionAmount();
        }
        return balance;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionRecordLoader.getTransactionList();
    }
}
