
package com.exceptiondemo;

public class Manual {
	public static void main(String[] args) {
		B b = new B();
		try {
			int ans = b.m1(10,0);
			System.out.println("Ans = "+ans);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("/ by two not possible");
		}
		catch(ArithmeticException e) {
			System.out.println("/ by zero not possible");
		}
		System.out.println("Thanks");
	}
}

class B {

	public int m1(int i, int j) throws ArithmeticException, ArrayIndexOutOfBoundsException{//Warning of exceptions
		if(j==2) {
			throw new ArrayIndexOutOfBoundsException(); // manual exception throw
			//throw new ArithmeticException();
		}
		return i/j;
	}
	
}