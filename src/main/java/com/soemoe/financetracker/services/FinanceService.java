package com.soemoe.financetracker.services;

import com.soemoe.financetracker.models.Expense;
import com.soemoe.financetracker.models.Income;
import com.soemoe.financetracker.models.Transaction;

public class FinanceService {
    private final Wallet wallet;

    //constructors
    public FinanceService() {
        wallet = new Wallet();
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
    }

    public double getBalance() {
        return wallet.getBalance();
    }

}
