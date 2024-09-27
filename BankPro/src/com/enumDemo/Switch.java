package com.enumDemo;

import java.util.Scanner;

public class Switch {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	while(true) {
			System.out.println("*******Menu*******");
			System.out.println("1.Tax\n2.Exit");
			int temp= sc.nextInt();
			if(temp ==2) {
				System.out.println("Thank you .... exyted");
				break;
			}
			System.out.println("Enter your city to calculate tax");
			String city = sc.next();
			switch(city) {
				case "mumbai":System.out.println("Your tax is 10%");
						break;
				case "pune":System.out.println("Your tax is 15%");
						break;
				case "delhi":System.out.println("Your tax is 18%");
						break;
				case "jaipur":System.out.println("Your tax is 20%");
						break;
				default:System.out.println("Enter the city name properly");
						break;
			}
			
		}
	sc.close();
	}
}
