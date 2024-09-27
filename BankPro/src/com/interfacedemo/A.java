package com.interfacedemo;

abstract public class A implements Ops{

	@Override
	public int deposit(int balance, int amount) {
		balance +=amount;
		return balance;
	}

}
