package com.practiceException;

public class OpsB extends OpsA{
	public void withdraw(Customer c, double amount) throws InvalidFundsException,InvalidAmountException,OverTheLimitException{
		if(amount > c.getBalance())
			throw new InvalidFundsException(c.getBalance(),amount);
		if(amount <= 0)
			throw new InvalidAmountException(c.getBalance(),amount);
		if(amount > Ops.limit)
			throw new OverTheLimitException(c.getBalance(),amount);
		
		double temp = c.getBalance() - amount;
		c.setBalance(temp);
	}
}
