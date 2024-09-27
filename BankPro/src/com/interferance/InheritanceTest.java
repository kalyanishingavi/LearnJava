package com.interferance;

class Test{
	static {
		System.out.println("Static");
	}
	public void Test() {
		System.out.println("copnstr");
	}
}
public class InheritanceTest {
	public static void main(String[] args) {
		System.out.println("main");
		Test t = new Test();
	}
}
