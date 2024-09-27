package com.threadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceDemo {
	public static void main(String[] args) {
		
	
	ExecutorService executor = Executors.newSingleThreadExecutor();
	
	Ap a = new Ap();
	executor.submit(a);
	executor.shutdown();
	
	
	
	}
}

class Ap implements Runnable{

	public void display() {
		System.out.println("My class");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		display();
	}
	
}
