package com.threadDemo;
class C extends Thread{
	long count = 0;
	String str = "";
	void compute() {
		synchronized(str) {
		for(long i=0;i<1000000000;i++) {
			count++;
		}
		}
	}
	
	public void run() {
		compute();
	}
}
public class App5 {
	public static void main(String[] args) throws InterruptedException {
		C c = new C();
		Thread t1 = new Thread(c,"T1");
		Thread t2 = new Thread(c,"T2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	
		System.out.println("Count = "+ c.count);
	}
}
