package com.soemoe.financetracker.ui;

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
    public String requestUserInput() {
        System.out.println("i -> add income, e -> add expense, s -> show balance, h -> show all transactions, q -> quit");
        return userInput.nextLine().toLowerCase();
    }

    public double getAmount(String transactionType) {
        transactionType = transactionType.equals("i") ? "Income" : "Expense";
        while (true) {
            System.out.printf("Enter Your %s: ", transactionType);
            String amount = userInput.nextLine();
            if (ValidationUtils.isNumeric(amount) && (Double.parseDouble(amount) >= 0)) {
                System.out.printf("%s added!\n", transactionType);
                System.out.println("---------------------------------");
                return Double.parseDouble(amount);
            }
            System.out.println("Invalid amount! Please Try again.");
        }
    }

    public String getUserDescription() {
        System.out.println("Description: ");
        String description = userInput.nextLine();
        System.out.println("Description added!");
        System.out.println("---------------------------------");
        return description;
    }

    public void showBalance(double balance) {
        System.out.printf("Your balance is: %.2f$\n", balance);
        System.out.println("---------------------------------");
    }

    public void showTransactionHistory(ArrayList<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            System.out.println("---------------------------------");
            System.out.printf("Transaction amount: %.2f\n", transaction.getTransactionAmount());
            System.out.printf("Type: %s\n", transaction.getTransactionType());
            System.out.printf("Date: %s\n", transaction.getTransactionDate());
            System.out.printf("Time: %s\n", transaction.getTransactionTime());
            System.out.printf("Description: %s\n", transaction.getDescription());
        }
    }


}
