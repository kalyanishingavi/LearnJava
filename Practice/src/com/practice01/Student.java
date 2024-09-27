package com.practice01;

public class Student {
	private String name;
	private int id=0;
	private String city;
	
	Student(){
		
	}
	
	Student(String name, int id, String city){
		this.name = name;
		this.id = id;
		this.city = city;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id= id;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String toString() {
		return "Name = " + name +" Id = "+ id + "City "+ city;
	}
}
