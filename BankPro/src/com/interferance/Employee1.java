package com.interferance;

public class Employee1 {
	
}
class employee{
Integer id;
String empname;
String status;
public employee(Integer id, String empname) {
	this.id = id;
	this.empname = empname;
}
}

class InvalidEmployeeException extends Exception{
	
	InvalidEmployeeException(String msg) {
		System.out.println(msg);
	}
}

class ExceptionCheck{
	public String validateEmployee(employee e) {
		try {
			if(e.empname == null || e.empname.length() < 3)
				throw new InvalidEmployeeException("Employee name invalid");
			if(e.id == null || e.id<=100)
				throw new InvalidEmployeeException("Employee id invalid");
			e.status="success";
		}
		catch(InvalidEmployeeException ex){
			e.status="exception";
			
		}
		return e.status;
		
	}
}
