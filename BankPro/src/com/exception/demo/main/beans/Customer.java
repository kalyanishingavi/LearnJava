package com.exception.demo.main.beans;

public class Customer {
	private String name;
	private double balance;
	
	public Customer(){
		
	}
	
	public Customer(String name, double balance){
		this.name = name;
		this.balance = balance;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBalancce(double balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return "[ Name = "+name +" Balance = "+ balance+" ]" ;
	}
}
