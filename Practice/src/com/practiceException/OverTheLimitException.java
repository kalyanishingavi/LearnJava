package com.practiceException;

public class OverTheLimitException extends Exception{

	private double balance;
	private double amount;
	 
	public OverTheLimitException(double balance, double amount) {
		this.balance = balance;
		this.amount = amount;
	}
	
	public String getmessage() {
		String msg = "Withdraw not possible \n"+
					"Account balance : "+ balance+
					"\nRequested amount to Withdraw : " + amount +
					"\nLimit for Withdrawl : " + Ops.limit +
					"\nAmount can't be more than limt";	
		return msg;
	}
}
