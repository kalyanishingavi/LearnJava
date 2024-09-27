package com.exception.demo.main.service;
import com.exception.demo.main.beans.Customer;
import com.exception.demo.main.ops.Ops;
abstract public class A implements Ops{


	public void deposit(Customer c, double amount) {
		double temp = c.getBalance() + amount;
		c.setBalancce(temp);
		
	}
	
}
