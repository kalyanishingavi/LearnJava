package com.ass2;

import java.util.Scanner;
public class A2{
	public static void main(String[] args) {
		// Scanner class declaration for standard input from console
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Student Details in 'roll:name:marks' pattern");
		// Taking input from the console
		String details = sc.nextLine();
		try {
			// Spliting the input to get details 
			String[] str = details.split(":");
			// converting the string to integer
			int marks = Integer.parseInt(str[2]);
			// Checking the result as per marks given
			String result = marks>=500 ? "Pass" : "Fail";
			// Printing the output to console
			System.out.println("Student Roll is : " + str[0]);
			System.out.println("Student Name is : " + str[1]);
			System.out.println("Student Marks is : " + marks);
			System.out.println("Student Result is : " + result);
		}
		catch(Exception e) {
			System.out.println("Please Enter the Details in valid format");
		}
		sc.close();
	}
}