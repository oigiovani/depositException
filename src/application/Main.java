package application;

import java.util.Locale;
import java.util.Scanner;

import models.entities.Account;
import models.exceptions.WithdrawException;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.println("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, initialBalance, withdrawLimit);
		System.out.println();
		
		try {
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}catch(WithdrawException e) {
			System.out.println("Withddraw error: " + e.getMessage());
		}
		sc.close();
	}

}
