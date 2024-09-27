package com.ass.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ass.model.Customer;
import com.ass.model.Product;

public class CustomerService {

	private EntityManager entityManager;
	Scanner sc;
	public CustomerService(EntityManager entityManager) {
		sc = new Scanner(System.in);
		this.entityManager = entityManager;
	}
	
	public void addCustomer() {
		Customer c = new Customer();
		System.out.println("Enter the Name of the customer");
		String name = sc.next();
		System.out.println("Enter the age of the Cusomer");
		int age = sc.nextInt();
		System.out.println("Enter the city of the customer");
		String city = sc.next();
		c.setName(name);
		c.setAge(age);
		c.setCity(city);
		entityManager.persist(c);
	}
	
	public void updateEmployeeById(int eid) {
		Customer c = entityManager.find(Customer.class, eid);
		System.out.println("Enter the name of Customer");
		c.setName(sc.next());
		System.out.println("Enter the age of Customer");
		c.setAge(sc.nextInt());
		System.out.println("Enter the city of Customer");
		c.setCity(sc.next());
		entityManager.persist(c);		
	}

	public void deleteCustomerRecord(int cid) {
		Customer customer = entityManager.find(Customer.class, cid);
		entityManager.remove(customer);
	}
	
	public List<Customer> getAllCustomer() {
		List<Customer> list = entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
		return list;
	}

	public void buyProduct(int cid, int pid) {
		Customer c = entityManager.find(Customer.class,	 cid);
		Product p = entityManager.find(Product.class, pid);
		List<Product> list = c.getProduct();
		list.add(p);
		c.setProduct(list);
		entityManager.persist(c);
		
	}



	public List<Customer> getCustomerDetailsByProduct(int pid) {
		Query query = entityManager.createQuery("select c from Customer c join c.product p where p.id=:pid", Customer.class);
		query.setParameter("pid", pid);
		List<Customer> list = 	query.getResultList();
		return list;
	}

	public void processRefund(int cid, int pid) {
		Customer c = entityManager.find(Customer.class, cid);
		Product p = entityManager.find(Product.class, pid);
		List<Product> list = c.getProduct();
		list.remove(p);
		c.setProduct(list);
		entityManager.persist(c);
		
	}

}
