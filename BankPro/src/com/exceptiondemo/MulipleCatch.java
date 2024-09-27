package com.exceptiondemo;
public class MulipleCatch {
	
	public static void main(String[] args) {
		AA a = new AA();
		try {
			
			a.m1();
		}
		catch(ArithmeticException e) {
			System.out.println("Arithmetic exception is thrown");
		}
		catch(RuntimeException e) {
			System.out.println("Run time exception is thrown");
		}
		catch(Exception e) {
			System.out.println("Exception is thrown");
		}
		finally {
			a=null;
		}
	}
}
class AA{
	public void m1(){
		throw new ArithmeticException();
	}	
}

// In multiple Catch blocks follow hierarchy small ---->> Large