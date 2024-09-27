package com.threadDemo;

class N extends Thread{
	void display() {
		
		System.out.println(Thread.currentThread().getName());
	}
	
	public void run() {
		display();
	}
}
public class App6 {
	public static void main(String[] args) {
		
		N a = new N();
		Thread t4 = new N();
		
		Thread t1 = new Thread(a,"New Thread");
		Thread t2 = new Thread(a,"New1");
		
		t1.start();
		t2.start();
		t4.start();
		
	}
}
