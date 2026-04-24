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
        System.out.println("---------------------------------");
        while (true) {
            input = financeUI.requestUserInput();
            if (input.length() == 1 && "iecshq".contains(input)) {
                switch (input) {
                    case "i" -> {
                        financeService.processTransaction(
                            new Income(
                                    financeUI.requestUserAmount(input),
                                    financeUI.requestUserDescription(),
                                    financeUI.assignUserCategory(financeService.getCategoryList("INCOME"))
                            ));
                        System.out.println("Income added!");
                    }
                    case "e" ->{
                        financeService.processTransaction(
                            new Expense(
                                    financeUI.requestUserAmount(input),
                                    financeUI.requestUserDescription(),
                                    financeUI.assignUserCategory(financeService.getCategoryList("EXPENSE"))
                            ));
                        System.out.println("Expense added!");
                    }
                    case "c" -> financeService.setCategoryRecordSaver(financeUI.requestUserCategoryValues());
                    case "s" -> financeUI.showBalance(financeService.getBalance());
                    case "h" -> financeUI.showTransactionHistory(financeService.getTransactionHistory());
                    case "q" -> System.exit(0);
                }
                continue;
            }
            System.out.println("Invalid input! Please Try again.");
        }
    }

}
