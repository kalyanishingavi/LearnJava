package com.jpa.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Department {
	
	@javax.persistence.Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(nullable = false)
	private String name;

	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(Integer id, String name) {
		super();
		Id = id;
		this.name = name;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
