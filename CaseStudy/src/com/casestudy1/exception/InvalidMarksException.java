package com.casestudy1.exception;

import com.casestudy1.Ops.Ops;

public class InvalidMarksException extends Exception{
	private double marks;
	public InvalidMarksException(double  marks){
		this.marks = marks;
	}
	public String message() {
		String msg ="Result Couldn't Computed\n"+ 
				"Your entered marks: "+marks+" \n"+
				"Total marks : "+ Ops.total + "\n" + 
				"Marks Could not be less than 0";
		return msg;
					
	}
}
