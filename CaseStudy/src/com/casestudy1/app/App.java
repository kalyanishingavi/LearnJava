package com.casestudy1.app;

import com.casestudy1.Student;
import com.casestudy1.Ops.A;
import com.casestudy1.exception.*;

public class App {
	public static void main(String[] args) {
		
	Student s = new Student("Gaurav",245);
	double result;
	A a = new A();
	
	try{
		result = a.computeResult(s);
		System.out.println("Your result is "+ result);
	}
	catch(IllegalMarksException e) {
		System.out.println(e.message());
	}
	catch(InvalidMarksException e) {
		System.out.println(e.message());
	}
	finally {
		a = null;
	}
}
}
