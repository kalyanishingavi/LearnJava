package com.service;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import com.junit.source.Product;
import com.junit.source.Source;

public class Service {
	@BeforeClass
	static public void beforeClass() {
		System.out.println("Before the class");
	}
	@Before
	public void before() {
		System.out.println("Before");
	}
	
	@Test
	public void testCase() {
		Source s = new Source();
		assertEquals(12,s.Sum(6, 6));
		assertEquals(22,s.Sum(10, 12));
		System.out.println("Test case done");
	}

	@Test
	public void testCase1() {
		Source s = new Source();
		assertEquals("A", s.grade(80));
		assertEquals("B", s.grade(65));
		assertEquals("C", s.grade(55));
		assertEquals("Invalid Marks", s.grade(101));
		assertEquals("Invalid Marks", s.grade(-32));
		System.out.println("Test case done");
	}
	@Test
	public void testcase2(){
		Source s = new Source();
		Product p = new Product("Vivo",20000);
		assertEquals(0,s.list.size());
		assertEquals("New Product added",s.addProduct(p));
		assertEquals(1,s.list.size());

		assertEquals(1,s.list.size());
		assertEquals("Product already Present", s.addProduct(p));
		
		Product p2 = new Product("Vivo",20000);
		assertEquals("New Product added",s.addProduct(p2));
		assertEquals(2,s.list.size());
	}
	@Test
	public void testcase3() {
		Source s = new Source();
		Product p = new Product("Vivo",20000);
		s.addProduct(p);
		assertEquals("Item removed",s.removeProduct(p));
		
	}
	@After
	public void after() {
		System.out.println("After");
	}
	
	@AfterClass
	static public void afterClass() {
		System.out.println("After the class");
	}
}
