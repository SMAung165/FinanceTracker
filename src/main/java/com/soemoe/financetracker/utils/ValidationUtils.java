package com.soemoe.financetracker.utils;

public class ValidationUtils {
    public static boolean isNumeric(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
