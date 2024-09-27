package com.cspassingrefrence;

abstract public class A implements Ops{
	public void deposit(Customer c, int amount) {
		int temp = c.getBalance() + amount;
		c.setBalance(temp);
	}
}
