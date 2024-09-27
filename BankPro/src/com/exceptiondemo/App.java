package com.exceptiondemo;

public class App {
	public static void main(String[] args) {
		A a = new A();
		try {
			int ans = a.m1(10,0);
			System.out.println("Ans = "+ans);
		}
		catch(ArithmeticException e) {
			System.out.println("/ by zero not possible");
		}
		System.out.println("Thanks");
	}
}

class A {

	public int m1(int i, int j) {
		
		return i/j;
	}
	
}