package com.service;

import com.junit.source.MockitoService;
import org.junit.*;
import org.mockito.Mockito;
public class MockitoTest {
	
	MockitoService ms;
	
	@Before 
	public void inti() {
		ms = Mockito.mock(MockitoService.class);
	}
	
	@Test
	public void test() {
		Mockito.when(ms.computeGrade(80)).thenReturn("A");
		Mockito.when(ms.computeGrade(65)).thenReturn("B");
		Mockito.when(ms.computeGrade(55)).thenReturn("C");
		
		Mockito.when(ms.computeGrade(180)).thenReturn("Invalid Marks");
		Mockito.when(ms.computeGrade(-32)).thenReturn("Invalid Marks");
		
	}
	
}
