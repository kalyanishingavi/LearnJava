package com.practice01;
import java.util.Scanner;


public class App {
	public static void main(String[] args) {
		String name;
		Student[] s = new Student[10];
		Opp a = new E();
		Scanner sim = new Scanner(System.in);
		System.out.println("Enter the details of 2 Students");
		int j= 1;
		for(int i=0;i<10;i++) {
			s[i] = new Student();
		}
		for(int i =0;i<2;i++) {
			System.out.println("Enter the Name " + (i+1) +"th Student");
			name = sim.next();
			s[i].setName(name);
			s[i].setId(j);
			System.out.println("Entern the city "+ (i+1) +"th Student");
			name = sim.next();
			s[i].setCity(name);
			j++;
		}
		int choice;
		while(true) {
			System.out.println("Enter your choice 1. Add,2.Find,3.update,4.view,5.delete,6.exit");
			choice = sim.nextInt();
			switch(choice) {
				case 1:  a.add(s);
					break;
				case 2 : a.find(s);
					break;
				case 3: a.update(s);
					break;
				case 4 : a.view(s);
					break;
				case 5 : a.delete(s);
					break;
				case 6 : System.exit(0);
				default : System.out.println("Invalid Choice");
			}
		}
		
		
	}
}
