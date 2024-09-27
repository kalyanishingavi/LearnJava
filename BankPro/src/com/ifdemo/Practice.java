package com.ifdemo;
import java.util.Scanner;
public class Practice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the marks");
		int marks = sc.nextInt();
		
		System.out.println("Enter the name of college");
		String clg = sc.next();
		if(marks>60)
			System.out.println("You pass");
		else
			System.out.println("Fail");
		
		System.out.println(marks>60?"You pass":"You failed");
		
		String grade = marks>60?"A":clg.equals("VP")?"B":"fail";
		System.out.println(grade);
		
	}
}
