package com.exceptiondemo;

public class TryCatchFinally {
public static void main(String[] args) {
		TCF a = new TCF();
		try {
			float f = 3.5f;  //Scope is limited to try block
			a.m1();
		}
		catch(NullPointerException e) {
			//System.out.println(f); --CF 
			System.out.println("Lenght cannot be calculated");
		}
		finally {
			//System.out.println(f); --CF 
			a = null;
		}
		//System.out.println(f); --CF 
		System.out.println(a);
		
}
}

class TCF {
	public void m1(){
		String str = null;
		System.out.println(str.length());
	}
}
