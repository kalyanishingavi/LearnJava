package com.p1;

public class A {

	int i;
	int j;
	
	public void display() {
		System.out.println("A");
	}

	public void sum(int i, int j) {
		int temp = i+j;
		System.out.println("Sum is = "+ temp);
	}

	public int compute(int i) {
		return i*10;
	}

	public void m1(int i, int j) {
		this.i = i;
		this.j= j;
	}

	public int m2() {
		return this.i+this.j;
	}

	public int computeResult(int marks, int total) {
		int temp = (marks*100)/total;
		return temp;
	}
	
}
