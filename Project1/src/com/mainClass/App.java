package com.mainClass;

import java.util.Scanner;

import com.database.DatabaseConnect;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DatabaseConnect dataConnect= new DatabaseConnect();
		while(true) {
			
			System.out.println("********Menu********");
			System.out.println("Press 1 for Fetch all policies");
			System.out.println("Press 2 for group policies available by adult and children");
			System.out.println("Press 3 for Sort all policies by term(Higher to Lower)");
			System.out.println("Press 4 for Display policies having preminum less than given amount");
			System.out.println("Press 0 for Exit");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting Bye");
				break;
			}
			
			switch(input) {
				case 1 : System.out.println("Record fetch");
						dataConnect.fetchAllRecord();
					break;
				case 2 :System.out.println("Group polocies");
					break;
				case 3 :System.out.println("Sort policies");
					break;
				case 4 :System.out.println("Display policies by premium");
					break;
				default : System.out.println("Invalid input from menu please Enter valid Input");
			}
		}
		
		sc.close();
		
		
	}
}
