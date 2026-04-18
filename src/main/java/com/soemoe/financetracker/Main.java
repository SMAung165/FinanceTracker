package com.soemoe.financetracker;

import com.soemoe.financetracker.models.Expense;
import com.soemoe.financetracker.models.Income;
import com.soemoe.financetracker.services.FinanceService;
import com.soemoe.financetracker.ui.FinanceUI;

public class Main {
    public static void main(String[] args) {
        FinanceUI financeUI = new FinanceUI();
        FinanceService financeService = new FinanceService();

        startProgram(financeUI, financeService);
    }

    private static void startProgram(FinanceUI financeUI, FinanceService financeService) {
        String input;
        System.out.println("Welcome!");
        while (true) {
            input = financeUI.requestUserInput();
            System.out.print("> ");
            if (input.length() == 1 && "iesq".contains(input)) {
                switch (input) {
                    case "i" -> financeService.processTransaction(
                            new Income(
                                    financeUI.getAmount(input),
                                    financeUI.getUserDescription()
                            ));
                    case "e" -> financeService.processTransaction(
                            new Expense(
                                    financeUI.getAmount(input),
                                    financeUI.getUserDescription()
                            ));
                    case "s" -> {
                        financeUI.showBalance(financeService.getBalance());
                        financeUI.showTransactionHistory(financeService.getTransactionHistory());
                    }
                    case "t" -> financeUI.showTransactionHistory(financeService.getTransactionHistory());
                    case "q" -> System.exit(0);
                }
                continue;
            }
            System.out.println("Invalid input! Please Try again.");
        }
    }

}
