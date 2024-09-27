package com.ass1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Employee{
	private int id;
	private String name;
	private String address;
	private int salary;
	
	// Zero argument constructor
	public Employee() {
		super();
	}
	//parameterized constructor with all fields
	public Employee(int id, String name, String address, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	
	//Getters and setters for all the instant variables
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	// Override toString method
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}

}

public class A1 {

	public static void main(String[] args) {
		// Creating Objects of Employee class
		Employee e1 = new Employee(1, "Gaurav", "Pune", 35000);
		Employee e2 = new Employee(2, "Ramdas", "Satara", 27000);
		Employee e3 = new Employee(3, "Prasad", "Dubai", 40000);
		Employee e4 = new Employee(4, "Siddhart", "Karmala", 35000);
		Employee e5 = new Employee(5, "Akash", "Osmanabad", 80000);
		// Adding to the list
		List<Employee> list = new ArrayList<>(Arrays.asList(e1,e2,e3,e4,e5));
		
		// Printing the List before sorting
		System.out.println("********Before Sort********");
		list.forEach(e->{System.out.println(e);});
		
		//Lambda Expression for sorting algorithm
		Collections.sort(list, 	(p1,p2)->{
			
			int salComparision = Integer.compare(p1.getSalary(), p2.getSalary());
			if(salComparision == 0) {
				return p1.getName().compareTo(p2.getName());
			}
			return salComparision;
		});
		
		// printing output to console
		System.out.println("\n\n\n*******After Sort********");
		list.forEach(e->{System.out.println(e);});
		
	}
}

