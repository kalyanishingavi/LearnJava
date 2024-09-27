package com.junit.source;

import java.util.ArrayList;


public class Source {
	
	public int Sum(int i,int j) {
		return i+j;
	}
	
	public String grade(int marks) {
		if(marks >100 || marks < 0)
			return "Invalid Marks";
		return marks>70?"A" : marks>60?"B" : "C";
	}
	
	public ArrayList<Product> list = new ArrayList<>();
	public String addProduct(Product p) {
		if(list.contains(p)) 
			return "Product already Present";
		
		list.add(p);
		return "New Product added";
	}
	public String removeProduct(Product p) {
		if(list.remove(p)) {
			return "Item removed";
		}
		return "Item not found";
	}
	
}
