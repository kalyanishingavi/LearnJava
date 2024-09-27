package com.ploymor;

public class Test {
	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.x);
		
		a.m1();
		
		a.display();
		
		System.out.println(a.compute());
	}
}

class A{
	int x=10;
	
	void m1(){
		System.out.println("M1 in A");
	}
	
	protected void display() {
		System.out.println("Display in A");
	}
	
	public int compute() {
		return 10;
	}
	
}

class B extends A{
	int x=5;
	
	void m1(){
		System.out.println("M1 in B");
	}
	
	public void display(int x) {
		System.out.println("Display in B");
	}
	
	public int compute(int q) {
		return 20;
	}
}
