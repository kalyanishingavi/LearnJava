package com.practiceException;

public class InvalidFundsException extends Exception{
	private double balance;
	private double amount;
	 
	public InvalidFundsException(double balance, double amount) {
		this.balance = balance;
		this.amount = amount;
	}
	
	public String getmessage() {
		String msg = "Withdrawl not possible \n"+
					"Account balance : "+ balance+
					"\nRequested amount to Withdraw : " + amount +
					"\nSurfuse amount Requested : "+ (amount - balance)+
					"\nInsufficient funds in the account\n";	
		return msg;
	}
}
