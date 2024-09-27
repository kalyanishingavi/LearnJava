package com.jpa.main.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.jpa.main.model.Department;
import com.jpa.main.model.Employee;

public class EmployeeService {
	Scanner sc;
	EntityManager entityManager = null;
	{
		sc = new Scanner(System.in);
	}
	
	public EmployeeService(EntityManager entityManager) {
			this.entityManager = entityManager;
	}

	public Employee readEmployeeDetails(Employee employee) {
		System.out.println("Enter the name");
		String name = sc.next();
		employee.setName(name);
		System.out.println("Enter the salary");
		double salary = sc.nextDouble();
		employee.setSalary(salary);
		System.out.println("Enter the city");
		String city = sc.next();
		employee.setCity(city);
		System.out.println("Enter the DepartmentID");
		int id = sc.nextInt();
		Department d = entityManager.find(Department.class, id);
		employee.setDepartment(d);
		return employee;
	}

	public List<Employee> fetchAllEmployee() {
		List<Employee> list = entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
		return list;
	}

	public Employee getEmployeeById(int sid) {
		return entityManager.find(Employee.class, sid);

	}

	public void updateEmployee(Employee e) {
		entityManager.persist(e);
		
	}

	public void DeleteEmployee(Employee e) {
		entityManager.remove(e);
		
	}
}
