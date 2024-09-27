package com.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Department;
import com.springboot.model.Employee;
import com.springboot.repository.DepartmentRepository;
import com.springboot.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	/*
	 * Insert data in employee : create employee
	 */
	@PostMapping("/employee/{did}")
	public Employee insertEmployee(@RequestBody Employee employee, @PathVariable("did") Long did) {
		Department department = departmentRepository.getById(did);
		employee.setDepartment(department);
		return employeeRepository.save(employee);
		
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(
			@RequestParam(name ="page",required = false,defaultValue = "0") Integer page,
			@RequestParam(name ="size",required = false,defaultValue = "2") Integer size){
		
		Pageable pageable =PageRequest.of(page, size);
		
		return employeeRepository.findAll(pageable).getContent();
	}
	 
	@GetMapping("/employee/{id}")  // localhost:8181/employee/1
	public Employee getEmployee(@PathVariable("id") Long id) {
		Employee emp = employeeRepository.getById(id);
		return emp;
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employeeNew) {
		/*
		 * step 1: Take the id of the employee that has to be updated : Id
		 * step 2: Go to the db and fetch record for the id : empdb
		 * step 3:Read new Employee details/values form the user : employeeNew
		 * step 4:Update empDb with new values : empdb <--- employeenew
		 */
		Employee empDB = employeeRepository.getById(id);
		
		if(employeeNew.getName() != null)
			empDB.setName(employeeNew.getName());
		if(employeeNew.getAge() != 0)
			empDB.setAge(employeeNew.getAge());
		if(employeeNew.getCity() != null)
			empDB.setCity(employeeNew.getCity());
		if(employeeNew.getSalary() != 0)
			empDB.setSalary(employeeNew.getSalary());
		if(employeeNew.getEmail() != null)
			empDB.setEmail(employeeNew.getEmail());
		
		return employeeRepository.save(empDB);
		
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}
	
	/*
	 * fetch list by employees by city
	 * passing request param in url : localhost:8181/employee/city/city?hogwards
	 */
	
	@GetMapping("/employee/city")
	public List<Employee> getEmployeeCity(@RequestParam("city") String city){
		List<Employee> list = employeeRepository.findByCity(city);
		return list;
	}
	
	/*
	 * fetch list of the employees having salary >70000
	 */
	
	@GetMapping("/employee/salary")
	public List<Employee> getEmployeeBySalary(@RequestParam("salary") double salary){
		List<Employee> list = employeeRepository.findBySalaryGreaterThan(salary);
		return list;
	}
	
	
	/*
	 * fetch the employee having age>19
	 */
	@GetMapping("/employee/age")
	public List<Employee> getEmployeeByAge(@RequestParam("age") int age){
		List<Employee> list = employeeRepository.findByAgeGreaterThan(age);
		return list;
	}
	
	/*
	 * method for getting employee details by department ID
	 */
	@GetMapping("/employee/deparment/{did}")
	public List<Employee> getEmployeeByDepartmentId(@PathVariable("did") Long did) {
		List<Employee> list = employeeRepository.findByDepartmentId(did);
		return list;
		
	}
}

/*
 *Fetch : getmapping
 *insert : postmapping
 *update : putmapping
 *delete : deletemapping 
 */
