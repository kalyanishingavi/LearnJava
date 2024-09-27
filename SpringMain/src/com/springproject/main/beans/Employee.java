package com.springproject.main.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@NotBlank(message = "")
	@Pattern(regexp = "[a-zA-z]+", message = "Name can contain only alphabets")
	private String name;
	
	@Size(max = 10,min = 5 ,message = "Size must between 5 to 10")
	private String city;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + "]";
	}
	
	
}
