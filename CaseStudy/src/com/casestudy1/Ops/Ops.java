package com.casestudy1.Ops;

import com.casestudy1.Student;
import com.casestudy1.exception.IllegalMarksException;
import com.casestudy1.exception.InvalidMarksException;

public interface Ops {
	double total = 300;
	double computeResult(Student s) throws IllegalMarksException,InvalidMarksException;
}
