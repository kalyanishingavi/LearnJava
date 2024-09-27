package com.practice01;
import java.util.Scanner;
public class E extends D{
	public void delete(Student[] s) {
		System.out.println("Enter the id to be delete");
		Scanner sc = new Scanner(System.in);
		int tempId = sc.nextInt();
		int i=0,check=0,skip =0;
		String temp=null;
		while(s[i].getName() != null) {
			if(tempId == s[i].getId()) {
				check = 1 ;
				System.out.println("ID found... Do you want to delete it");
				System.out.println("Preious data is like");
				System.out.println("Id = "+s[i].getId()+" Name = "+s[i].getName()+" City = "+s[i].getCity());
				System.out.println("Enter Y to delete or any other key to skip");
				temp = sc.next();
				if(!temp.equalsIgnoreCase("Y")) {
					skip =1;
					break;
				}
			}
			if(check == 1 && temp.equalsIgnoreCase("Y")) {
				s[i].setId((i+1));
				s[i].setName(s[i+1].getName());
				s[i].setCity(s[i+1].getCity());
				check = 1;
				skip =1;
			}
			i++;
		}
		if(check == 0) {
			System.out.println("ID not found to delete");
		}
		else if(skip == 0){
			System.out.println("\nSkip");
		}
		else {
			System.out.println("\nId deleted Successfully...");
		}
			
	}
}
