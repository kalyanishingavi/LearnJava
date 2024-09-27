package com.exception.demo.main.exceptions;

import com.exception.demo.main.ops.Ops;

public class OverTheLimitException extends Exception{

	private double balance;
	private double amount;
	
	public OverTheLimitException(double balance, double amount) {
		super();
		this.balance = balance;
		this.amount = amount;
	}


	public String display() {
		String msg = "Withdrwal Cannot be processed\n"+
					"current balance : INR."+ balance +"\n"+
					"Requested amount : INR."+ amount + "\n"+
					"Transaction Limit : INR. "+Ops.limit+"\n"+
					"Surfuse amount: INR. "+(amount - Ops.limit);
		return msg;
	}
}
