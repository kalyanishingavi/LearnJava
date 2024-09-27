package com.service;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.junit.source.ExceptionClass;
import com.junit.source.InvalidMarksException;

public class ExceptionTest {
	ExceptionClass ec;
	@Before
	public void inti() {
		ec = new ExceptionClass();
	}
	
	@Test(expected = ArithmeticException.class)
	public void exceptiondemo() {
		assertEquals(2, ec.cal(10, 5));
		assertEquals(2, ec.cal(20, 0));
		
	}
	
	@Test
	public void excep() throws InvalidMarksException{
		assertEquals("A",ec.computeGrade(85));
		assertEquals("B",ec.computeGrade(75));
		assertEquals("C",ec.computeGrade(32));
		
		try {
			ec.computeGrade(102);
		}
		catch(InvalidMarksException e) {
			System.out.println(e.message());
		}
		
		try {
			ec.computeGrade(-1);
		}
		catch(InvalidMarksException e) {
			System.out.println(e.message());
		}
	}
	@After
	public void after() {
		ec = null;
	}
}
