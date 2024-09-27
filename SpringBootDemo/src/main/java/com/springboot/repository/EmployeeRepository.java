package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	public List<Employee> findByCity(String city);

	public List<Employee> findBySalaryGreaterThan(double salary);

	public List<Employee> findByAgeGreaterThan(int age);

	public List<Employee> findByDepartmentId(Long id);
}
