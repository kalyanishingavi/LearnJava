package com.practiceException;

abstract public class OpsA implements Ops{
	
	public void deposit(Customer c , double amount) throws InalidAmountDeopsitException{
		if (amount <= 0 )
			throw new InalidAmountDeopsitException(c.getBalance(),amount);
		
		double temp = c.getBalance() + amount;
		c.setBalance(temp);
	}
	
}
