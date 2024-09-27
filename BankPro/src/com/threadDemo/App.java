package com.threadDemo;

class A extends Thread{
	void display() {
		System.out.println(A.currentThread().getName());
		
	}
	
	public void run() {
		display();
		
	}
}
public class App {
	public static void main(String[] args) {
		A a = new A();
		a.setName("MYthread");
		a.start();  // new thread start
		
		A a1 = new A();
		a1.setName("New thread");
		a1.start(); // new thread start
	}
}
