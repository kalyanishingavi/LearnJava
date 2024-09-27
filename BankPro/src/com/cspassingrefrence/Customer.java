package com.cspassingrefrence;

public class Customer {
	private String name;
	private int balance;
	
	Customer(){
		
	}
	Customer(String name, int balance){
		this.name = name;
		this.balance = balance;
	}
	
	public String getName(){
		return name;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return "Name = "+ name + "  Balance = "+ balance + ".";
	}
	
}
