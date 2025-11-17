package com.cg.backend;

import java.util.Scanner;

public class Atm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner scanner = new Scanner(System.in);
		        UserService userService = new UserServiceImpl();

		        System.out.println("===== Welcome to Java ATM =====");
		        System.out.print("Enter User ID: ");
		        String userId = scanner.nextLine();
		        System.out.print("Enter PIN: ");
		        String pin = scanner.nextLine();

		        try {
		            User user = userService.login(userId, pin);
		            AtmOperation atm = new AtmOperationsImpl(user);
		            int option;

		            do {
		                System.out.println("\n--- Menu ---");
		                System.out.println("1. Check Balance");
		                System.out.println("2. Deposit");
		                System.out.println("3. Withdraw");
		                System.out.println("4. Mini Statement");
		                System.out.println("5. Exit");
		                System.out.print("Choose option: ");
		                option = scanner.nextInt();

		                switch (option) {
		                    case 1:
		                        atm.checkBalance();
		                        break;
		                    case 2:
		                        System.out.print("Enter deposit amount: ");
		                        double deposit = scanner.nextDouble();
		                        atm.deposit(deposit);
		                        break;
		                    case 3:
		                        System.out.print("Enter withdrawal amount: ");
		                        double withdraw = scanner.nextDouble();
		                        try {
		                            atm.withdraw(withdraw);
		                        } catch (InsufficientFundsException e) {
		                            System.out.println(e.getMessage());
		                        }
		                        break;
		                    case 4:
		                        atm.miniStatement();
		                        break;
		                    case 5:
		                        System.out.println("Thank you for using our ATM!");
		                        break;
		                    default:
		                        System.out.println("Invalid option.");
		                }
		            } while (option != 5);

		        } catch (InvalidPinException e) {
		            System.out.println(e.getMessage());
		        }

		        scanner.close();
		    }

		



}
