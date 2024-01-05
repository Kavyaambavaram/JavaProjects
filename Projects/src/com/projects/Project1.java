package com.projects;

import java.util.Scanner;

class BankApplication {
    private static final String storedUsername = "Kavya";
    private static final String storePassword = "Kavya@123";

    public static String getUsername() {
        return storedUsername;
    }

    public static String getPassword() {
        return storePassword;
    }

    Scanner sc = new Scanner(System.in);
    int minimumbal = 500;
    int balance = minimumbal;

    public void Deposite() {
    	int depamount;
		System.out.println("Enter the amount deposite amount");
		depamount = sc.nextInt();
		if (depamount > 0) {
			balance += depamount;
			System.out.println(depamount + " Deposit successful! Current balance: " + balance);
		} else {
			System.out.println("Invalid! Please enter a valid amount");
		}
    }

    public void Withdraw() {
    	int wdamount;
		System.out.println("Enter the withdraw amount");
		wdamount = sc.nextInt();
		if (balance-wdamount>=minimumbal) {
			balance -= wdamount;
			System.out.println("Rs." + wdamount + " Withdrawal successful. Current balance: " + balance);
		} else {
			System.out.println("Insufficient funds! Minimum balance is required " + minimumbal);
		}
    }

    public void balEnquiry() {
    	System.out.println("Current balance in your account is " + balance);
    }
}

public class Project1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankApplication obj = new BankApplication();

        System.out.println("Enter the user name");
        String enteredUsername = sc.next();

        if (enteredUsername.equals(BankApplication.getUsername())) {
            System.out.println("Enter your password ");
            String enteredPassword = sc.next();

            if (enteredPassword.equals(BankApplication.getPassword())) {
                System.out.println("Login successful. Welcome, " + enteredUsername + "!");
                char ch;
                do {
                    System.out.println("Here Select an option to continue");
                    System.out.println("1) Deposit 2) Withdraw 3) Balance");
                    int option = sc.nextInt();
                    switch (option) {
                        case 1:
                            obj.Deposite();
                            break;
                        case 2:
                            obj.Withdraw();
                            break;
                        case 3:
                            obj.balEnquiry();
                            break;
                        default:
                            System.out.println("Invalid Option");
                    }
                    System.out.println("Do you want to continue :Y/N");
                    ch = sc.next().charAt(0);
                } while (ch == 'Y');
            } else {
                System.out.println("Invalid Password. Please enter correct password");
            }
        } else {
            System.out.println("Invalid Username. Enter valid username");
        }
    }
}
