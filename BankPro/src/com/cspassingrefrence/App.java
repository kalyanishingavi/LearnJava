package com.cspassingrefrence;

public class App {
	public static void main(String[] args) {
		Customer C1 = new Customer ("Gaurav",5000);
		
		B b = new B();
		
		b.deposit(C1, 1000);
		System.out.println(C1);
		
		b.withdrwal(C1, 3000);
		System.out.println(C1);
		
		Customer C2 = new Customer("Ram",10000);
		
		b.deposit(C2, 1000);
		System.out.println(C2);
		
		b.withdrwal(C2, 3000);
		System.out.println(C2);
	}
}
