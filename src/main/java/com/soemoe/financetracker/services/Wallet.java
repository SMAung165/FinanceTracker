package com.soemoe.financetracker.services;


public class Wallet {
    private double balance;

    //constructor
    public Wallet() {
        balance = 0;
    }

    //getters
    public double getBalance() {
        return balance;
    }

    //setters
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
