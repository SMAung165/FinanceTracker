package com.soemoe.financetracker;

import com.soemoe.financetracker.models.Category;
import com.soemoe.financetracker.models.Income;
import com.soemoe.financetracker.services.FinanceService;
import com.soemoe.financetracker.ui.FinanceUI;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FinanceUI financeUI = new FinanceUI();
        FinanceService financeService = new FinanceService();

        startProgram(financeUI, financeService);
    }

    private static void startProgram(FinanceUI financeUI, FinanceService financeService) {
        String input;
        ArrayList<Object> userInputValues;
        ArrayList<String> userCreateCategoryValues;

        System.out.println("Welcome!");
        System.out.println("---------------------------------");
        while (true) {
            input = financeUI.requestUserInput();
            if (input.length() == 1 && "iecshq".contains(input)) {
                switch (input) {
                    case "i" -> {
                        System.out.println("Tip: Type 'exit' to cancel");
                        userInputValues = new ArrayList<>();
                        userInputValues.add(financeUI.requestUserAmount(input));
                        if ((double) userInputValues.get(0) == -1) break;

                        userInputValues.add(financeUI.requestUserDescription());
                        if ((userInputValues.get(1)) == null) break;

                        userInputValues.add(financeUI.assignUserCategory(financeService.getCategoryList("INCOME")));
                        if (userInputValues.get(2) == null) break;

                        financeService.processTransaction(new Income((double) userInputValues.get(0), (String) userInputValues.get(1), (Category) userInputValues.get(2)));
                        System.out.println("Income added!");
                    }
                    case "e" -> {
                        System.out.println("Tip: Type 'exit' to cancel");
                        userInputValues = new ArrayList<>();
                        userInputValues.add(financeUI.requestUserAmount(input));
                        if ((double) userInputValues.get(0) == -1) break;

                        userInputValues.add(financeUI.requestUserDescription());
                        if ((userInputValues.get(1)) == null) break;

                        userInputValues.add(financeUI.assignUserCategory(financeService.getCategoryList("EXPENSE")));
                        if (userInputValues.get(2) == null) break;

                        financeService.processTransaction(new Income((double) userInputValues.get(0), (String) userInputValues.get(1), (Category) userInputValues.get(2)));
                        System.out.println("Expense added!");
                    }
                    case "c" -> {
                        System.out.println("Tip: Type 'exit' to cancel");
                        userCreateCategoryValues = financeUI.requestUserCategoryValues();
                        if (userCreateCategoryValues == null) break;
                        financeService.setCategoryRecordSaver(userCreateCategoryValues);
                    }
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
