package com.casestudy1;

public class Student {
	private String name;
	private double marks;
	
	public Student() {
		
	}
	public Student(String name, double marks) {
		this.name = name;
		this.marks = marks;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getMarks() {
		return this.marks;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	public String toString() {
		return "[ Name = " + name + " Marks = " + marks +" ]";
	}
}	
