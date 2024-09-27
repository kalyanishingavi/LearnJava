package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.model.Employee;
import com.springboot.model.Employee_Project;

public interface EmployeeProjectRepository extends JpaRepository<Employee_Project, Long>{

	@Query("select e from Employee_Project ep join ep.project p join ep.employee e where p.id=?1")
	List<Employee> getEmployeeByProject(Long pid);

}
