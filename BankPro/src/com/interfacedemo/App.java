package com.interfacedemo;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customer c = new Customer();
		c.name = "Gaurav";
		c.balance = 5000;
		while(true) {
		System.out.println("Enter the Choice 1.Deposit 2.withdraw");
		int choice = sc.nextInt();
		int amount;
		B b = new B();
		switch(choice) {
		
		case 1:
		System.out.println("Enter the amount to be deposited");
		amount = sc.nextInt();
		
		
		c.balance = b.deposit(c.balance, amount);
		System.out.println(c.balance);
		break;
		
		case 2: System.out.println("Enter the amount to be Withdraw");
		amount = sc.nextInt();
		
		c.balance = b.withdraw(c.balance, amount);
		System.out.println(c.balance);
	}
	}
	}
}

