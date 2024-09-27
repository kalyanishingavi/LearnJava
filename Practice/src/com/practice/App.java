package com.practice;

public class App {
	public static void main(String[] args) {
		Customer C = new Customer("Gaurav",5000);
		
		B b = new B();
		System.out.println(C);
		
		b.deposit(C, 2000);
		System.out.println(C);
		
		b.withdraw(C, 4000);
		System.out.println(C);
		
		Customer C1 = new Customer("Vivek",4982);
		
		System.out.println(C1);
		
		b.deposit(C1, 2323);
		System.out.println(C1);
		
		b.withdraw(C1, 123);
		System.out.println(C1);
	}
}