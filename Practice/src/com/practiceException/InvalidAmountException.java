package com.practiceException;

public class InvalidAmountException extends Exception{
	
	private double balance;
	private double amount;
	 
	public InvalidAmountException(double balance, double amount) {
		this.balance = balance;
		this.amount = amount;
	}
	
	public String getmessage() {
		String msg = "Withdrwal not possible \n"+
					"Account balance : "+ balance+
					"\nRequested amount to Withdraw : " + amount +
					"\nAmount can't be less than 0 or 0\n";	
		return msg;
	}
}
