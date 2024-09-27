package com.casestudy1.Ops;

import com.casestudy1.Student;
import com.casestudy1.exception.*;
public class A implements Ops{


	@Override
	public double computeResult(Student s) throws IllegalMarksException,InvalidMarksException{
		if(s.getMarks() > 300)
			throw new IllegalMarksException(s.getMarks());
		if(s.getMarks() < 0)
			throw new InvalidMarksException(s.getMarks());
		return (s.getMarks()*100)/Ops.total;
	}
}
