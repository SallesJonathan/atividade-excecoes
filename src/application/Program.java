package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		try {
		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial Balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		Double withdrawLimit= sc.nextDouble();
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.print("Enter amount for withdraw: ");
		Double with = sc.nextDouble();
	
			account.withdraw(with);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		catch(InputMismatchException e){
			System.out.println("Unexpected error!");
		}
		catch(DomainExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		sc.close();
	}

}
