package com.soemoe.financetracker.services;

import com.soemoe.financetracker.models.Expense;
import com.soemoe.financetracker.models.Income;


import java.util.ArrayList;

public class FinanceService {
    private Wallet wallet;

    //constructors
    public FinanceService() {
        wallet = new Wallet();
    }

    public void userInputProcessor(ArrayList<String> userInput) {
        //do something
    }
}
