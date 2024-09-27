package com.ass.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ass.model.Customer;
import com.ass.model.Product;
import com.ass.model.Vendor;

public class ProductService {

	private EntityManager entityManager;
	Scanner sc = null;
	public ProductService(EntityManager entityManager) {
		sc = new Scanner(System.in);
		this.entityManager = entityManager;
	}
	public void addProduct() {
		Product p = new Product();
		Vendor v = new Vendor();
		System.out.println("Enter the name of product");
		String name = sc.next();
		System.out.println("Enter the price of product");
		double price = sc.nextDouble();
		System.out.println("Enter the id of the Vendor");
		int id = sc.nextInt();
		p.setName(name);
		p.setPrice(price);
		v = entityManager.find(Vendor.class, id);
		p.setVendor(v);
		entityManager.persist(p);
		
	}
	public List<Product> getAllProducts() {
		List<Product> list = entityManager.createQuery("select p from Product p", Product.class).getResultList();
		return list ;
	}
	public List<Product> listOfProductByVendor(int vid) {
		Query query = entityManager.createQuery("select p from Product p where p.vendor.id=:vid", Product.class);
		query.setParameter("vid", vid);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public List<Product> getProductDetailsByCustomer(int custid) {
		Query query = entityManager.createQuery("select p from Product p join p.customer c where c.id=:cid", Product.class);
		query.setParameter("cid", custid);
		List<Product> list = query.getResultList();
		return list;
	}
}
