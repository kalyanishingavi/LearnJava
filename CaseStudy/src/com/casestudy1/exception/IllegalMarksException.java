package com.casestudy1.exception;

import com.casestudy1.Ops.Ops;

public class IllegalMarksException extends Exception{
	private double marks;
	public IllegalMarksException(double  marks){
		this.marks = marks;
	}
	public String message() {
		String msg ="Result Couldn't Computed\n"+ 
				"Your entered marks: "+marks+" \n"+
				"Total marks : "+ Ops.total + "\n" + 
				"Marks Could not be more than total marks";
		return msg;
					
	}
}
