package com.springproject.main.service;

import org.springframework.stereotype.Component;

import com.springproject.main.beans.Customer;

@Component
public class CustomerService {

	public Customer fetchCustomer(int id) {
		Customer c = new Customer(id,"Harry","Hogwards",21);
		return c;
	}

	

}
