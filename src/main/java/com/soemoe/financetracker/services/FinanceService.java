package com.soemoe.financetracker.services;

import com.soemoe.financetracker.models.Category;
import com.soemoe.financetracker.models.Expense;
import com.soemoe.financetracker.models.Income;
import com.soemoe.financetracker.models.Transaction;
import com.soemoe.financetracker.utils.CategoryRecordLoader;
import com.soemoe.financetracker.utils.CategoryRecordSaver;
import com.soemoe.financetracker.utils.TransactionRecordLoader;
import com.soemoe.financetracker.utils.TransactionRecordSaver;

import java.util.ArrayList;

public class FinanceService {
    private final Wallet wallet;
    private final TransactionRecordSaver transactionRecordSaver;
    private final CategoryRecordSaver categoryRecordSaver;

    //constructors
    public FinanceService() {
        transactionRecordSaver = new TransactionRecordSaver();
        categoryRecordSaver = new CategoryRecordSaver();

        wallet = new Wallet(new TransactionRecordLoader().getTransactionList(), new CategoryRecordLoader().getCategoryList());
        wallet.setBalance(getCurrentBalance());
    }

    //getters
    public double getBalance() {
        return wallet.getBalance();
    }

    //methods
    private double getCurrentBalance() {
        double currentBalance = 0;
        for (Transaction transaction : wallet.getTransactions()) {
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
        return wallet.getTransactions();
    }

    public ArrayList<Category> getCategoryList(String categoryType) {
        ArrayList<Category> categoryList = new ArrayList<>();

        for (Category category : wallet.getCategories()) {
            if (category.getCategoryType().equals(categoryType.toLowerCase())) categoryList.add(category);
        }

        if (categoryList.isEmpty()) {
            categoryList.add(new Category(categoryType, "temp", "temp"));
        }

        return categoryList;
    }

    public void setCategoryRecordSaver(ArrayList<String> userDefinedValues) {
        wallet.addNewCategory(new Category(userDefinedValues.get(0), userDefinedValues.get(1), userDefinedValues.get(2)));
        categoryRecordSaver.saveCategoryRecord(wallet.getCategories());
    }
}
