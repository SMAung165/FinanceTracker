package com.soemoe.financetracker.ui;

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
        System.out.println("i -> add income, e -> add expense, s-> show wallet, q -> quit");
        return userInput.nextLine().toLowerCase();
    }

    public double getAmount(String transactionType) {
        transactionType = transactionType.equals("i") ? "Income" : "Expense";
        while (true) {
            System.out.printf("Enter Your %s: ", transactionType);
            String amount = userInput.nextLine();
            if (ValidationUtils.isNumeric(amount) && (Double.parseDouble(amount) >= 0)) {
                System.out.printf("%s added!\n", transactionType);
                return Double.parseDouble(amount);
            }
            System.out.println("Invalid amount! Please Try again.");
        }
    }

    public String getUserDescription() {
        System.out.println("Description: ");
        String description = userInput.nextLine();
        System.out.println("Description added!");
        return description;
    }

    public void showBalance(double balance) {
        System.out.printf("Your balance is: %.2f$\n", balance);
    }

    public void showTransactionHistory(ArrayList<String> transactionHistory){
        //show all history
    }


}
