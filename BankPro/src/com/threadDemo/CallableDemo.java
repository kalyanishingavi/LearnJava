package com.threadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService ex = Executors.newSingleThreadExecutor();
		
		One o = new One();
		try {
		Future<Integer> res = ex.submit(o);
		System.out.println(res.get());
		}
		catch(Exception e) {
			System.out.println("Exception");
		}
		finally {
		ex.shutdown();
		}
	}
}	

class One implements Callable<Integer> {
	public int div(int n1,int n2) throws Exception{
		return n1/n2;
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return div(30,20);
	}
	
}