package com.practice01;
import java.util.Scanner;
abstract public class D extends C{
	Scanner sc = new Scanner(System.in);
	public void find(Student[] s) {
		int i =0,tempId,check=0;
		System.out.println("Enter the Id to find details");
		tempId = sc.nextInt();
		while(s[i].getName() != null) {
			if(tempId == s[i].getId() ) {
				System.out.println("Id\tName\tCity");
				System.out.println(s[i].getId()+"\t"+s[i].getName()+"\t"+s[i].getCity());
				check = 1;
			}
			i++;
		}
		if(check==0) {
			System.out.println("ID not found");
		}
	}
}
