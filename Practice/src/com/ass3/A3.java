package com.ass3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	
	//public getter and setter methods of all fields
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
	
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}
	
	// overriding hashcode method by address
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		return result;
	}
	
	// Overriding Equals method only by address
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}
	
	
	

}
public class A3 {
	public static void main(String[] args) {
		// Creating Objects of Employee class
		PerformOperation ops = new PerformOperation();
		Employee e1 = new Employee(1, "Gaurav", "Pune", 35000);
		Employee e2 = new Employee(2, "Ramdas", "Satara", 27000);
		Employee e3 = new Employee(3, "Prasad", "Satara", 40000);
		Employee e4 = new Employee(4, "Siddhart", "Karmala", 35000);
		Employee e5 = new Employee(5, "Akash", "Karmala", 80000);
		
		// Adding employees to the list 
		List<Employee> list = new ArrayList<>(Arrays.asList(e1,e2,e3,e4,e5));
		// Output to console before removing
		System.out.println("********Before Removing********");
		list.forEach(e->{System.out.println(e);});
		
		list = ops.removeDuplicateEmployee(list);
		
		// Output to console after removing
		System.out.println("********After Removed********");
		list.forEach(e->{System.out.println(e);});
		
	}
}

class PerformOperation{
	public List<Employee> removeDuplicateEmployee(List<Employee> employees){
		// logic for remove the duplicate employees by city from the list
		List<Employee> list = employees.stream().distinct().collect(Collectors.toList());
		return list;
	}

}
