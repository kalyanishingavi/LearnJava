package com.practiceException;

public interface Ops {
	double limit = 50000;
	void deposit(Customer c,double amount) throws InalidAmountDeopsitException;
	void withdraw(Customer c, double amount) throws InvalidFundsException,InvalidAmountException,OverTheLimitException;
}
