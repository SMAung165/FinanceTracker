package com.soemoe.financetracker;

import com.soemoe.financetracker.services.FinanceService;
import com.soemoe.financetracker.ui.FinanceUI;

public class Main {
    public static void main(String[] args) {
        FinanceUI financeUI = new FinanceUI();
        FinanceService financeService = new FinanceService();

        startProgram(financeUI);
    }


    private static void startProgram(FinanceUI financeUI) {
        String input = financeUI.requestUserInput();
        while (true) {
            System.out.print("> ");
            if (input.length() == 1 && "iesq".contains(input)) {
                switch (input) {
                    case "i" -> {

                    }
                    case "e" -> {

                    }
                    case "s" -> {

                    }
                    case "q" -> {
                        System.exit(0);
                    }
                }
            }
            System.out.println("Invalid input! Please Try again.");
        }
    }

}
