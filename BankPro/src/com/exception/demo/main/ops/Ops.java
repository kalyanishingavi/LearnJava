package com.exception.demo.main.ops;
import com.exception.demo.main.beans.Customer;
import com.exception.demo.main.exceptions.InvalidFundsExceptions;
import com.exception.demo.main.exceptions.OverTheLimitException;

public interface Ops {
	double limit = 50000;
	public void withdraw(Customer c, double amount) throws InvalidFundsExceptions,OverTheLimitException;
	public void deposit(Customer c,double amount);
}
