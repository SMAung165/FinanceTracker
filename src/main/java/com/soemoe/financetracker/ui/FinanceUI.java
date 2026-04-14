package com.soemoe.financetracker.ui;

import com.soemoe.financetracker.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FinanceUI {
    private Scanner userInput;

    //constructors
    public FinanceUI() {
        userInput = new Scanner(System.in);
    }

    //methods
    public String requestUserInput() {
        System.out.println("Welcome!");
        System.out.println("i -> add income, e -> add expense, s-> show wallet, q -> quit");
        return userInput.nextLine().toLowerCase();
    }

    public double getAmount(String transactionType) {
        while(true){
            System.out.printf("Enter your %s: ", transactionType.equals("i") ? "income" : "expense");
            String amount = userInput.nextLine();
            if (ValidationUtils.isNumeric(amount)) return Double.parseDouble(amount);
            System.out.println("Invalid amount! Please Try again.");
        }
    }


}
