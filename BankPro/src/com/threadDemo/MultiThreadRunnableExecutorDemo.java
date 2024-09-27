package com.threadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadRunnableExecutorDemo {
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(4);
		
		es.submit(new player1());
		es.submit(new player2());
		es.submit(new player3());
		
		es.shutdown();
	}
}

class player1 implements Runnable{

	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Player 1 started");
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			System.out.println("not done");
		}
		System.out.println("Player 1 ended");
		
	}
	
}

class player2 implements Runnable{

	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Player 2 started");
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			System.out.println("not done");
		}
		System.out.println("Player 2 ended");
		
	}
	
}

class player3 implements Runnable{

	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Player 3 started");
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			System.out.println("not done");
		}
		System.out.println("Player 3 ended");
		
	}
	
}
