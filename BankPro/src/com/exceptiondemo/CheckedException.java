package com.exceptiondemo;

import java.io.IOException;

public class CheckedException {
	public static void main(String[] args) {
		C c = new C();
		try {
			c.m1(102);
		}
		catch(IOException e){		// Exception must be handled
			System.out.println("Value must be less than 100");
		}
		System.out.println("Thanks");
	}
}

class C {

	public void m1(int i) throws IOException{   //Warning must be given
		if(i>100)
			throw new IOException();        //checked exception
		System.out.println("Processed");
	}
}
/*
 * If a checked exception is thrown it must be
 * 	1. Warned
 * 	2. Catched
 * 
 * If a unchecked exception is thrown it is programmers choice to handle it or gives warining
 */



