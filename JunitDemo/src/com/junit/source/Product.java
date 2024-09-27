package com.junit.source;

public class Product {
	private String name;
	private double id;
	
	public Product(String name, double id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", id=" + id + "]";
	}
	
	
}
