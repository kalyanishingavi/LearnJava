package com.threadDemo;

class A1 implements Runnable{
	void display() {
		System.out.println(Thread.currentThread().getName());
	}
	
	 public void run() {
		display();
	}
	
}
public class App2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new A1(),"New Thread");
		t1.start();
	}
}
