package com.threadDemo;
class AA extends Thread{
	void display() {
		System.out.println(AA.currentThread().getName());
	}
	
	public void run() {
		display();
	}
	
}
public class App1 {
	public static void main(String[] args) {
		A a = new A();
		Thread t1 = new Thread(a,"New Thread");
		t1.start();
		
	}
}
