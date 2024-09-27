package com.practiceException;

public class InalidAmountDeopsitException extends Exception{
	private double balance;
	private double amount;
	 
	public InalidAmountDeopsitException(double balance, double amount) {
		this.balance = balance;
		this.amount = amount;
	}
	
	public String getmessage() {
		String msg = "Deposit not possible \n"+
					"Account balance : "+ balance+
					"\nRequested amount to deposit : " + amount +
					"\nAmount can't be less than 0 or 0\n";	
		return msg;
	}
	
}
