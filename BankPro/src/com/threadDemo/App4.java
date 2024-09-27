package com.threadDemo;

class B extends Thread {
	void display() {
		System.out.println(B.currentThread().getName());
		try {
			B.sleep(1000);
			} catch (InterruptedException e) {
	}
		System.out.println(B.currentThread().getName());
		
	}
	
	public void run() {
		display();
	}
}
public class App4 {
	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread(new B(),"T1");
		Thread t2 = new Thread(new B(),"T2");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("Thanks");
		
	}
}
