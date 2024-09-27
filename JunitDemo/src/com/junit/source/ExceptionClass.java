package com.junit.source;

public class ExceptionClass {
	public int cal(int n1,int n2) {
		return n1/n2;
	}
	
	public String computeGrade(int marks) throws InvalidMarksException{
		if(marks>100) {
			throw new InvalidMarksException("marks cannot greater than 100");
		}
		if(marks<0) {
			throw new InvalidMarksException("Marks cannot be less than 0");
		}
		
		return marks>80?"A" : marks >60 ? "B" : "C";
	}
}
