package com.stringDemo;

public class App {
	public static void main(String[] args) {
		
		// String can be created using two metods
		// 1.Literal: Goes in String pool(Special memory)
		// 2.Object: oes in stack
		
		// String literal 
		String s1 = "Hello Java";
		
		// String Object
		String s2 = new String("Hello Java");
		
		// String literal 
		String s3 = "Hello Java";
		
		// String Object
		String s4 = new String("Hello Java");
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1 == s2);

		
		System.out.println(s1.equals(s3));
		
		System.out.println(s1 == s3);
		
		System.out.println(s2.equals(s4));
		System.out.println(s2 == s4);
	}
}
