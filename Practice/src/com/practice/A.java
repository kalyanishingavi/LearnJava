package com.practice;

abstract public class A implements Opp{
	
	public void deposit(Customer c, int amount) {
		int temp = c.getBalance() + amount;
		c.setBalance(temp);
	}
	
}
