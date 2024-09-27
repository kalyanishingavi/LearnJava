package com.exception.demo.main.service;
import com.exception.demo.main.beans.Customer;
import com.exception.demo.main.ops.Ops;
import com.exception.demo.main.exceptions.InvalidFundsExceptions;
import com.exception.demo.main.exceptions.OverTheLimitException;
public class B extends A{

	public void withdraw(Customer c, double amount) throws InvalidFundsExceptions,OverTheLimitException{
		if(amount > c.getBalance())
			throw new InvalidFundsExceptions(c.getBalance(),amount);
		if(amount > Ops.limit)
			throw new OverTheLimitException(c.getBalance(),amount);
		double temp = c.getBalance() - amount;
		c.setBalancce(temp);
	}
}
