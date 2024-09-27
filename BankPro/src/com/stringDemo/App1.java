package com.stringDemo;

public class App1 {
	public static void main(String[] args) {
		
		String s1 = "hello java";
		String s2 = "hello java";
		
		System.out.println(s1);
		System.out.println(s2);
		s1 = s1.toUpperCase();
		
		System.out.println(s1);
		
		System.out.println(s1.toLowerCase());
		
		System.out.println(s1.length());
		
		System.out.println(s1.concat(s2));
		
		String str = "           Harry Potter            ";
		System.out.println(str);
		System.out.println(str.trim());
		System.out.println(str);
		
		System.out.println(str.compareTo(s1));
		System.out.println(s1.toUpperCase().intern() == s2.toUpperCase());
		
		System.out.println(s1.toLowerCase().equals(s2.toLowerCase()));
		
		System.out.println(s1.indexOf("z"));
		
		
	}
}
