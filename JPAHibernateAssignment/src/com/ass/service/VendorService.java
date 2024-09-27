package com.ass.service;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.ass.model.Vendor;

public class VendorService {

	private EntityManager entityManager;

	public VendorService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void populateVendor() {
		Vendor v1 = new Vendor();
		v1.setName("abc.LTD");
		v1.setCity("London");
		Vendor v2 = new Vendor();
		v2.setName("pqr.LTD");
		v2.setCity("Delhi");
		Vendor v3 = new Vendor();
		v3.setName("xyz.LTD");
		v3.setCity("Mumbai");
		entityManager.persist(v1);
		entityManager.persist(v2);
		entityManager.persist(v3);
	}
	
}
