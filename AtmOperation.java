package com.cg.backend;

public interface AtmOperation {
    void checkBalance();
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
    void miniStatement();
}
