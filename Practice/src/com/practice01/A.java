package com.practice01;
import java.util.Scanner;
abstract public class A implements Opp{
	private String temp;
	Scanner sc = new Scanner(System.in);
	public void add(Student[] s) {
		int i=0;
		while(s[i].getName() != null) {
			i++;
		}
		if(i<9) {
			System.out.println("Id = "+(i+1));
			s[i].setId((i+1));
			System.out.println("Enter the name");
			temp = sc.next();
			s[i].setName(temp); 
			System.out.println("Enter the City");
			temp = sc.next();
			s[i].setCity(temp);
		}
		else {
			System.out.println("Students full");
		}
	}

}