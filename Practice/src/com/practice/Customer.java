package com.practice;

public class Customer {
	private String name;
	private int balance;
	
	Customer(){
		super();
	}
	
	Customer(String name, int balance){
		this.name = name;
		this.balance = balance;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return "Name = "+name +" Balance = "+ balance;
	}
}
