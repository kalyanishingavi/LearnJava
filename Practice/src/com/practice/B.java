package com.practice;

public class B extends A{
	
	
	public void withdraw(Customer c,int amount) {
		int temp = c.getBalance()-amount;
		c.setBalance(temp);
	}

}
