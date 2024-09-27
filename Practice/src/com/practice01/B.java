package com.practice01;
import java.util.Scanner;
abstract public class B extends A{
	Scanner sc = new Scanner(System.in);
	String temp;
	public void update(Student[] s) {
		System.out.println("Enter the id to delete");
		int tempId,check=0,i=0;
		tempId = sc.nextInt();
		while(s[i].getName()!=null) {
			if(tempId == s[i].getId()) {
				System.out.println("Previous data be like");
				System.out.println("Id = "+s[i].getId() + "Name = "+s[i].getName()+"City = "+s[i].getCity());
				System.out.println("Enter the Updated Name");
				temp = sc.next();
				s[i].setName(temp);
				System.out.println("Enter the updated city");
				temp = sc.next();
				s[i].setCity(temp);
				System.out.println("Updated Successfully");
				check = 1;
				break;
			}
			i++;
		}
		if(check == 0) {
			System.out.println("Id not found");
		}
	}

}
