package com.main.app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ass.model.Customer;
import com.ass.model.Product;
import com.ass.service.CustomerService;
import com.ass.service.ProductService;
import com.ass.service.VendorService;

public class App {	
	public static void main(String[] args) {
		
		EntityManagerFactory entityFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner sc = null;
		
		try {
			entityFactory = Persistence.createEntityManagerFactory("myecomdb");
			entityManager = entityFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			
			sc = new Scanner(System.in);
			CustomerService customerService = new CustomerService(entityManager);
			VendorService vendorService = new VendorService(entityManager);
			ProductService productService = new ProductService(entityManager); 
			while(true) {
				
				System.out.println();
				System.out.println("Enter 1 for Add customer or Add Products");
				System.out.println("Enter 2 for Populate Vendor");
				System.out.println("Enter 3 for Update customer record");
				System.out.println("Enter 4 for Delete Customer record(Cascading way)");
				System.out.println("Enter 5 for display all customers");
				System.out.println("Enter 6 for display all products");
				System.out.println("Enter 7 for allow customer to buy product");
				System.out.println("Enter 8 for list of product by vendor");
				System.out.println("Enter 9 for Product information by customer ID");
				System.out.println("Enter 10 for Customer Information by Product ID");
				System.out.println("Enter 11 for process redund(Delete from relationTable)");
				System.out.println("Enter 0 for exit");
				int input = sc.nextInt();
				if(input == 0) {
					System.out.println("Exiting bye....");
					break;
				}
				System.out.println();
				transaction.begin();
				switch(input) {
				case 1:
					System.out.println("Enter 1 for add Customer ");
					System.out.println("Enter 2 for add Product ");
					int in = sc.nextInt();
					switch(in) {
						case 1:
							customerService.addCustomer();
							System.out.println("Customer added");
							break;
						case 2:
							productService.addProduct();
							System.out.println("Product Added");
							break;
						}
					transaction.commit();
					break;
				case 2:
					vendorService.populateVendor();
					System.out.println("Vendor populated sucessfully....");
					transaction.commit();
					break;
				case 3:
					System.out.println("Enter the ID of Customer to update");
					int eid = sc.nextInt();
					customerService.updateEmployeeById(eid);
					System.out.println("Customer details updated sucessfully");
					transaction.commit();
					break;
				case 4:
					System.out.println("Enter the Customer ID");
					int cid = sc.nextInt();
					customerService.deleteCustomerRecord(cid);
					System.out.println("Customer record deleted Sucessfully");
					transaction.commit();
					break;
				case 5:
					List<Customer> list = customerService.getAllCustomer();
					
					Collections.sort(list ,(c1,c2)->{
						int age = c1.getAge() - c2.getAge();
						return age;
					});
					
					list.forEach(c -> {
						System.out.print("ID :- " + c.getId());
						System.out.print("  ||  Name :- " + c.getName());
						System.out.print("  ||  Age :- " + c.getAge());
						System.out.print("  ||  City :- " + c.getCity() +"\n");
					});
					transaction.commit();
					break;
				case 6:
					List<Product> listOfProduct = productService.getAllProducts();
					Collections.sort(listOfProduct,(p1,p2)->{
						int priceComparison = (int) (p1.getPrice() - p2.getPrice());
						return priceComparison;
					});
					
					listOfProduct.forEach(p -> {
						System.out.print("Product_ID :- "+p.getId());
						System.out.print("  || Name :- " + p.getName());
						System.out.print("  ||  Price :- " + p.getPrice());
						System.out.print("  ||  VendorId :- " + p.getVendor().getId() +"\n");
					});
					transaction.commit();
					break;
				case 7:
					System.out.println("Enter customer id");
					cid = sc.nextInt();
					System.out.println("Enter product id");
					int pid = sc.nextInt();
					customerService.buyProduct(cid,pid);
					System.out.println("Produt buyed sucessfully....");
					transaction.commit();
					break;
				case 8:
					System.out.println("Enter the ID of vendor");
					int vid = sc.nextInt();
					List<Product> listProduct = productService.listOfProductByVendor(vid);
					listProduct.forEach(p -> {
						System.out.print("ID :- "+p.getId());
						System.out.print("  || Name :- " + p.getName());
						System.out.print("  ||  Price :- " + p.getPrice());
						System.out.print("  ||  VendorId :- " + p.getVendor().getId() +"\n");
					});
					
					transaction.commit();
					break;
				case 9:
					System.out.println("Enter the Customer ID to get Product deatils");
					cid = sc.nextInt();
					List<Product> listOfProductByCustomerID = productService.getProductDetailsByCustomer(cid);
					listOfProductByCustomerID.forEach(p -> {
						System.out.print("Product_ID :- "+p.getId());
						System.out.print("  || Name :- " + p.getName());
						System.out.print("  ||  Price :- " + p.getPrice());
						System.out.print("  ||  VendorId :- " + p.getVendor().getId() +"\n");
					});
					transaction.commit();
					break;
				case 10:
					System.out.println("Enter the Product ID to get Customer deatils");
					pid = sc.nextInt();
					List<Customer> listOfCustomer = customerService.getCustomerDetailsByProduct(pid);
					listOfCustomer.forEach(c -> {
						System.out.print("ID :- "+c.getId());
						System.out.print("  ||  Name :- " + c.getName());
						System.out.print("  ||  Age :- " + c.getAge());
						System.out.print("  ||  City :- " + c.getCity() +"\n");
					});
					transaction.commit();
					break;
				case 11:
					System.out.println("Enter the Customer ID");
					cid = sc.nextInt();
					System.out.println("Enter the Product ID");
					pid = sc.nextInt();
					customerService.processRefund(cid,pid);
					System.out.println("Refunded Sucessfully");
					transaction.commit();
					break;
				default:
					System.out.println("Please Enter a valid Input");
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
			sc.close();
		}
	}
}

class A implements Comparator<Customer>{
	@Override
	public int compare(Customer c1, Customer c2) {
		return c1.getAge()-c2.getAge();
	}
}
