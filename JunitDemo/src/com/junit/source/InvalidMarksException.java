package com.junit.source;

public class InvalidMarksException extends Exception {
	
	String mes;
	
	InvalidMarksException(String mes){
		this.mes = mes;
	}
	
	public String message() {
		return mes;
	}
	
	
}
