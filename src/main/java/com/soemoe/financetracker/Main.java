package com.soemoe.financetracker;

import com.soemoe.financetracker.models.Category;
import com.soemoe.financetracker.models.Expense;
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
        double requestedUserAmount;
        String requestedUserDescription;
        Category requestedUserCategory;

        ArrayList<String> userCreateCategoryValues;

        System.out.println("Welcome!");
        System.out.println("---------------------------------");
        while (true) {
            input = financeUI.requestUserOperationSelection();
            if (input.length() == 1 && "iecshq".contains(input)) {
                switch (input) {
                    case "i" -> {
                        System.out.println("Tip: Type 'exit' to cancel");

                        requestedUserAmount = financeUI.requestUserAmount(input);
                        if (requestedUserAmount == -1) break;

                        requestedUserDescription = financeUI.requestUserDescription();
                        if (requestedUserDescription == null) break;

                        requestedUserCategory = financeUI.requestUserCategory(financeService.getCategoryList("INCOME"));
                        if (requestedUserCategory == null) break;

                        processTransactionType(input,financeService,requestedUserAmount,requestedUserDescription,requestedUserCategory);

                        System.out.println("Income added!");
                    }
                    case "e" -> {
                        System.out.println("Tip: Type 'exit' to cancel");

                        requestedUserAmount = financeUI.requestUserAmount(input);
                        if (requestedUserAmount == -1) break;

                        requestedUserDescription = financeUI.requestUserDescription();
                        if (requestedUserDescription == null) break;

                        requestedUserCategory = financeUI.requestUserCategory(financeService.getCategoryList("EXPENSE"));
                        if (requestedUserCategory == null) break;

                        processTransactionType(input,financeService,requestedUserAmount,requestedUserDescription,requestedUserCategory);

                        System.out.println("Expense added!");
                    }
                    case "c" -> {
                        System.out.println("Tip: Type 'exit' to cancel");
                        userCreateCategoryValues = financeUI.requestUserNewCategoryValues();
                        if (userCreateCategoryValues == null) break;
                        financeService.addCategory(userCreateCategoryValues);
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

    private static void processTransactionType(String type, FinanceService financeService, double requestedUserAmount, String requestedUserDescription, Category requestedUserCategory) {
        switch (type) {
            case "i" -> financeService.processTransaction(new Income(
                    requestedUserAmount,
                    requestedUserDescription,
                    requestedUserCategory
            ));
            case "e" -> financeService.processTransaction(new Expense(
                    requestedUserAmount,
                    requestedUserDescription, requestedUserCategory));

            default -> System.out.println("Invalid operation!");
        }

    }

}
