package com.stringDemo;

public class App2 {
public static void main(String[] args) {
	
	String str = "91 India 44 UK 566 USA";
	
	String[] sarray = str.split("\\s");
	
	for(String temp : sarray) {
		System.out.println(temp);
	}
	
	System.out.println("******Country names*******");
	
	String[] saray = str.split("\\d+\\s");
	
	for(String temp : saray) {
		System.out.println(temp);
	}
	
	System.out.println("*******Country Codes**********");
	String[] sarry = str.split("\\s[a-zA-Z]+");
	
	for(String temp : sarry) {
		System.out.println(temp.trim());
	}
	
	String email = "abc@gmail.com";
	
	boolean valid = email.matches("\\w+@\\w+\\.\\w+");
	System.out.println("Validation = "+valid);
			
	
	/*
	 * Regex
	 *   \w : word [a-zA-Z0-9]
	 *   \d : decimal [0-9]
	 *   + : one or more
	 *   * : zero or more
	 *   ^ : starts with
	 *   $ : ends with
	 *   \s or " " : Space
	 */
}
}
