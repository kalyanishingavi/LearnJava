package com.encapsulationdemo;

public class Encapdemo {
public static void main(String[] args) {
	Student S = new Student();
	
	System.out.println(S.getX());
	System.out.println(S.getY());
	
	S.setX(10);
	S.setY(20);
	
	System.out.println(S.getX());
	System.out.println(S.getY());
	
	S.m1();
}
}

class Student {
	private int x;
	private int y;
	Student(){
	
	}
	Student(int x,int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void m1() {
		int temp = x+y;
		System.out.println(temp);
	}
}