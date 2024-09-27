package com.springboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.model.Employee_Project;
import com.springboot.model.Project;
import com.springboot.repository.EmployeeProjectRepository;
import com.springboot.repository.EmployeeRepository;
import com.springboot.repository.ProjectRepository;

@RestController
public class EmployeeProjectController {
	
	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeProjectRepository employeeProjectRepository;
	
	@PostMapping("/employee/project/{eid}/{pid}")
	public Employee_Project postEmployeeProject(@PathVariable("eid") Long eid,@PathVariable("pid") Long pid) {
		/*
		 * fetch project by the paramaeter pid
		 */
		Project project = projectRepository.getById(pid);
		/*
		 * fetch Employee by the parameter eid
		 */
		Employee employee = employeeRepository.getById(eid);
		/*
		 * create an onject of Employeeproject entity
		 */
		Employee_Project employee_Project = new Employee_Project();
		
		employee_Project.setEmployee(employee);
		employee_Project.setProject(project);
		
		LocalDate ld = LocalDate.of(2020, 12, 30);
	
		Date date = new Date();
		date = Date.from(ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		
		try {
			date = SimpleDateFormat.getInstance().parse(ld.toString());
		} catch (ParseException e) { }
		
		employee_Project.setWorkingFrom(date);
		employeeProjectRepository.save(employee_Project);
		return employee_Project;
	}
	
	
	@GetMapping("/employeeproject")
	public List<Employee_Project> getAllProjectEmployee(){
		return employeeProjectRepository.findAll();
	}
	
	@DeleteMapping("/employeeproject/{epid}")
	public void deleteProjectEmployee(@PathVariable("epid") Long epid) {
		employeeProjectRepository.deleteById(epid);
	}
	
	@GetMapping("/employee/project/{pid}")
	public List<Employee> getEmployeeByProject(@PathVariable("pid") Long pid){
		List<Employee> list = employeeProjectRepository.getEmployeeByProject(pid);
		return list;
	}
}
