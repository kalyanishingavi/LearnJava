package com.practiceException;
import java.util.Scanner;
public class App {
	public static void main(String[] args) {
		Customer c1 = new Customer("Gaurav",60000);
		Scanner sc = new Scanner(System.in);
		System.out.println(c1);
		double amount = 0;
		OpsB ops = new OpsB();
		while (true) {
			System.out.println("1.Deposit\n2.Withdraw\n3.view\n4.exit  ");
			int temp = sc.nextInt();
			if(temp == 4) {
				System.out.println("\nThank you Exited");
				break;
			}
			switch(temp ) {
			case 1 : System.out.println("Enter the amount to deposit");
					amount = sc.nextDouble();
					try {
						ops.deposit(c1, amount);
						System.out.println("Amount Deposited: " + amount);
						System.out.println("Account Balance: " + c1.getBalance());
					}
					catch(InalidAmountDeopsitException e) {
						System.out.println(e.getmessage());
					}
					break;
			case 2 : System.out.println("Enter the amount to Withdraw");
					amount = sc.nextDouble();
					try {
						ops.withdraw(c1, amount);
						System.out.println("Amount withdwal " + amount);
						System.out.println("Account Balance: " + c1.getBalance());
					}
					catch(InvalidAmountException e) {
						System.out.println(e.getmessage());
					}
					catch(InvalidFundsException e) {
						System.out.println(e.getmessage());
					}
					catch(OverTheLimitException e) {
						System.out.println(e.getmessage());
					}
					catch(RuntimeException e) {
						System.out.println("Process cannot executed");
					}
					break;
			case 3 : System.out.println(c1);
					break;
			default : System.out.println("Enter the valid input\n");
				
			}
		}
	}
}
