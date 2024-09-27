package com.exception.demo.main.exceptions;

public class InvalidFundsExceptions extends Exception{
	private double balance;
	private double amount;
	
	public InvalidFundsExceptions(double balance, double amount) {
		this.amount = amount;
		this.balance = balance;
	}
	
	
	
	public String display() {
		String msg = "Withdrwal Cannot be processed\n"+
					"current balance : INR."+balance+"\n"+
					"Requested amount : INR."+ amount + "\n"+
					"Funds Needed : INR. "+(amount - balance);
		return msg;
	}
}
