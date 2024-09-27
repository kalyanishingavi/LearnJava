package com.jpa.main;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.main.model.Employee;
import com.jpa.main.service.DepartmentService;
import com.jpa.main.service.EmployeeService;
import com.jpa.main.service.ProjectService;

public class App {
	public static void main(String[] args) {
		
		/*
		 *EntityManagerFactory help us to reach to the persistance.xml file
		 */
		EntityManagerFactory entityFactory = null;
		
		/*
		 * EntityManager help us to manage and perform on our entities
		 */
		EntityManager entityManager = null;
		
		/*
		 * EntityTransaction Needed so that all operations in the DB as atomic
		 */
		EntityTransaction transaction = null;
		
		try {
			entityFactory = Persistence.createEntityManagerFactory("mycompanydb");
			entityManager = entityFactory.createEntityManager();
			transaction = entityManager.getTransaction();

			Scanner sc = new Scanner(System.in);
			EmployeeService es = new EmployeeService(entityManager);
			DepartmentService departmentService = new DepartmentService(entityManager);
			ProjectService projectService = new ProjectService(entityManager);
			while (true) {
				transaction.begin();
				System.out.println("Enter 1 for add");
				System.out.println("Enter 2 for fetch");
				System.out.println("Enter 3 for update");
				System.out.println("Enter 4 for delete");
				System.out.println("Enter 5 for Set/Populate Department");
				System.out.println("Enter 6 for fetch record by Department ID");
				System.out.println("Enter 7 for Set/populate Project");
				System.out.println("Enter 8 for set project to Employee");
				System.out.println("Enter 0 for exit");
				int input = sc.nextInt();
				if(input ==0) {
					System.out.println("Exiting bye");
					transaction.commit();
					break;
				}
				switch(input) {
				case 1:
					Employee employee = new Employee();
					employee = es.readEmployeeDetails(employee);
					entityManager.persist(employee);
					System.out.println("Inserted successfully");
					transaction.commit();
					break;
					
				case 2:
					List<Employee> list = es.fetchAllEmployee();
					System.out.println("*******Employee details*******");
					for(Employee e : list) {
						System.out.print("ID = " + e.getId()+ "  ");
						System.out.print("Name = "+ e.getName() + "  ");
						System.out.print("Salary = " + e.getSalary()+ "  ");
						System.out.print("City = "+ e.getCity()+"  ");
						System.out.println("Department = " + e.getDepartment().getName());
						System.out.println("\n******************************");
						
					}
					transaction.commit();
					break;
				case 3:
					System.out.println("Enter the ID you want to update");
					int sid = sc.nextInt();
					Employee e = es.getEmployeeById(sid);
					if(e==null) {
						throw new RuntimeException("Invalid Input");
					}
					e = es.readEmployeeDetails(e);
					es.updateEmployee(e);
					System.out.println("ID updated sucessfully");
					transaction.commit();
					break;
					
				case 4:
					System.out.println("Enter the ID you want to Delete");
					int eid = sc.nextInt();
					e = es.getEmployeeById(eid);
					if(e==null) {
						throw new RuntimeException("Invalid Input");
					}
					es.DeleteEmployee(e);
					System.out.println("ID deleted sucessfully");
					transaction.commit();
				break;
					
				case 5 :
					departmentService.populate();
					System.out.println("Department Added");
					transaction.commit();
					break;
				case 6:
					System.out.println("Enter the Department ID");
					int id = sc.nextInt();
					list = departmentService.fetchEmployeeByDepartmentId(id);
					System.out.println("*******Employee details*******");
					for(Employee emp : list) {
						System.out.print("ID = " + emp.getId()+ "  ");
						System.out.print("Name = "+ emp.getName() + "  ");
						System.out.print("Salary = " + emp.getSalary()+ "  ");
						System.out.print("City = "+ emp.getCity()+"  ");
						System.out.println("Department = " + emp.getDepartment().getName());
						System.out.println("\n**************************************************************");
					}
					transaction.commit();
					break;
				case 7:
					projectService.populate();
					System.out.println("Project Added");
					transaction.commit();
					break;
				case 8:
					System.out.println("Enter the employee ID");
					eid = sc.nextInt();
					System.out.println("Enter the Project ID");
					int pid = sc.nextInt();
					
					projectService.assignProjectToEmployee(eid,pid);
					transaction.commit();
					System.out.println("Assigned the project");
					break;
				default:
					transaction.commit();
					break;
				}
			}
			
		
		}
		catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}
		finally {
			entityManager.close();
			entityFactory.close();
		
			
		}
	}
	
}
