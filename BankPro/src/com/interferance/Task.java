package com.interferance;

enum Status{
	OPEN,CLOSED
}
public class Task {
	private Status status = null;
	private  Integer points = null;
	
	Task(final Status status,final Integer points){
		this.status=status;
		this.points=points;
		
	}
	
	
}
