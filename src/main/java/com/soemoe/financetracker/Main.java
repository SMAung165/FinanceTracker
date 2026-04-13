package com.soemoe.financetracker;

import com.soemoe.financetracker.models.Expense;
import com.soemoe.financetracker.models.Income;
import com.soemoe.financetracker.models.Transaction;
import com.soemoe.financetracker.services.Wallet;

public class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet();
        Transaction income = new Income(244);
        Transaction expense = new Expense(11);
        wallet.processTransaction(income);
        wallet.processTransaction(expense);
        System.out.println(wallet.getBalance());
    }
}
