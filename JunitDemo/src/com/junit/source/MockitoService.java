package com.junit.source;

public class MockitoService {
	
	public String computeGrade(int marks) {
		if(marks>100 || marks < 0)
			return "Invalid Marks";
		return marks>70?"A" : marks >60 ? "B" : "C";
	}
}
