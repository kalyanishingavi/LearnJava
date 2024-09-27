package com.cspassingrefrence;

public class B extends A{
	public void withdrwal(Customer c,int amount) {
		int tem = c.getBalance() - amount;
		c.setBalance(tem);
	}

}
