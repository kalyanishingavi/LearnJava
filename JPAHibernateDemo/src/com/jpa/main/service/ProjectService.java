package com.jpa.main.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jpa.main.model.Employee;
import com.jpa.main.model.Project;

public class ProjectService {

	EntityManager entityManager;
	public ProjectService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void populate() {
		Project p1 = new Project();
		p1.setName("Banking_Project");
		p1.setCredits(1000);
		entityManager.persist(p1);
		
		Project p2 = new Project();
		p2.setName("Corp_Project");
		p2.setCredits(800);
		entityManager.persist(p2);
	}
	public void assignProjectToEmployee(int eid, int pid) {
		
		Employee employee = entityManager.find(Employee.class, eid);
		Project project = entityManager.find(Project.class, pid);
		
		List<Project> list = employee.getProject();
		list.add(project);
		
		entityManager.persist(employee);
	}
	

}
