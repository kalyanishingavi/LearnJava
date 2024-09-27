package com.constructureDemo;

public class App {
public static void main(String[] args) {
	Student s = new Student("Gaurav",19);
	System.out.println(s.age +"\n"+ s.name);
	
	System.out.println(s);
}
}

class Student extends Object{
	String name;
	int age;
	
	Student(){
		super();
	}
	Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
	  	return "Gaurav";
	}
}
