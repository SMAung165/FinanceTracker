package com.soemoe.financetracker.ui;

import com.soemoe.financetracker.models.Category;
import com.soemoe.financetracker.models.Transaction;
import com.soemoe.financetracker.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class FinanceUI {
    private final Scanner userInput;

    //constructors
    public FinanceUI() {
        userInput = new Scanner(System.in);
    }

    //methods
    public String requestUserOperationSelection() {
        System.out.println("i -> add income, e -> add expense, c -> create category, s -> show balance, h -> show all transactions, q -> quit");
        System.out.print("> ");
        return userInput.nextLine().toLowerCase();
    }

    public double requestUserAmount(String transactionType) {
        transactionType = transactionType.equals("i") ? "INCOME" : "EXPENSE";
        System.out.println("---------------------------------");
        while (true) {
            System.out.printf("%s AMOUNT: ", transactionType);
            String amount = userInput.nextLine();

            if (cancelProcess(amount)) return -1; //cancel current process?

            if (ValidationUtils.isNumeric(amount) && (Double.parseDouble(amount) >= 0)) {
                return Double.parseDouble(amount);
            }
            System.out.println("Invalid amount! Please Try again.");
        }
    }

    public String requestUserDescription() {
        System.out.println("---------------------------------");
        System.out.print("DESCRIPTION: ");
        String userDescription = userInput.nextLine();
        if (cancelProcess(userDescription)) return null; //cancel current process?
        return userDescription;
    }

    public Category requestUserCategory(ArrayList<Category> categoryList) {

        if (categoryList.isEmpty()) {
            System.out.println("No category found! Please create one first!");
            return null;
        }

        System.out.println("---------------------------------");
        System.out.println("SELECT CATEGORY");
        System.out.println("---------------");

        while (true) {
            int i = 0;
            for (Category category : categoryList) {
                System.out.println(i++ + ". " + category.getLabel());
            }
            System.out.print("> ");
            String userChoice = userInput.nextLine();

            if (ValidationUtils.isNumeric(userChoice) && Integer.parseInt(userChoice) >= 0 && Integer.parseInt(userChoice) < categoryList.size()) {
                return categoryList.get(Integer.parseInt(userChoice));
            } else if (cancelProcess(userChoice)) {
                return null;
            } else {
                System.out.println("Invalid Input!");
                System.out.println("--------------");
            }
        }

    }

    public void showBalance(double balance) {
        System.out.println("---------------------------------");
        System.out.printf("Your balance is: %.2f ₫\n", balance);
    }

    public void showTransactionHistory(ArrayList<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            System.out.println("---------------------------------");
            System.out.printf("Transaction amount: %.2f ₫\n", transaction.getTransactionAmount());
            System.out.printf("Type: %s\n", transaction.getTransactionType());
            System.out.printf("Category: %s\n", transaction.getCategory().getLabel());
            System.out.printf("Date: %s\n", transaction.getTransactionDate());
            System.out.printf("Time: %s\n", transaction.getTransactionTime());
            System.out.printf("Description: %s\n", transaction.getDescription());
        }
    }

    public ArrayList<String> requestUserNewCategoryValues() {
        ArrayList<String> userInputValues = new ArrayList<>();
        String[] prompts = {"TYPE", "LABEL", "DESCRIPTION"};
        String userInputValue;
        System.out.println("---------------------------------");
        for (String prompt : prompts) {
            if (prompt.equals("TYPE")) {
                System.out.println("Select Category Type");
                System.out.println("---------------------------------");
                while (true) {
                    System.out.println("i -> income, e -> expense");
                    System.out.print("> ");
                    userInputValue = userInput.nextLine().toLowerCase();
                    if(cancelProcess(userInputValue)) return null; //cancel current process?
                    if (("ie").contains(userInputValue) && userInputValue.length() == 1) {
                        userInputValue = userInputValue.equals("i") ? "income" : "expense";
                        break;
                    }
                    System.out.println("Invalid selection!");
                }
            } else {
                System.out.print(prompt + ": ");
                userInputValue = userInput.nextLine();
                if(cancelProcess(userInputValue)) return null; //cancel current process?
            }
            userInputValues.add(userInputValue);
        }
        System.out.println("Success!");
        return userInputValues;
    }

    //utils
    private boolean cancelProcess(String input) {
        return input.equals("exit");
    }
}
