package com.p1;

public class Customer {
	public int balance;
	public int deposit(int amount){
		int temp = amount + this.balance;
		return temp;
	}

}
