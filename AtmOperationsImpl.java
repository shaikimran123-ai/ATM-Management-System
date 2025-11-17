package com.cg.backend;

import java.util.ArrayList;
import java.util.List;

public class AtmOperationsImpl implements AtmOperation{
	
	    private User user;
	    private List<String> transactions;

	    public AtmOperationsImpl(User user) {
	        this.user = user;
	        this.transactions = new ArrayList<>();
	    }

	    @Override
	    public void checkBalance() {
	        System.out.println("Current Balance: ₹" + user.getBalance());
	    }

	    @Override
	    public void deposit(double amount) {
	        if (amount > 0) {
	            user.setBalance(user.getBalance() + amount);
	            transactions.add("Deposited: ₹" + amount);
	            System.out.println("Successfully deposited ₹" + amount);
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    @Override
	    public void withdraw(double amount) throws InsufficientFundsException {
	        if (amount <= 0) {
	            System.out.println("Invalid withdrawal amount.");
	            return;
	        }

	        if (amount > user.getBalance()) {
	            throw new InsufficientFundsException("Insufficient funds.");
	        }

	        user.setBalance(user.getBalance() - amount);
	        transactions.add("Withdrawn: ₹" + amount);
	        System.out.println("Successfully withdrawn ₹" + amount);
	    }

	    @Override
	    public void miniStatement() {
	        System.out.println("--- Mini Statement ---");
	        if (transactions.isEmpty()) {
	            System.out.println("No transactions available.");
	        } else {
	            transactions.stream()
	                .skip(Math.max(0, transactions.size() - 5))
	                .forEach(System.out::println);
	        }
	    }
	}



