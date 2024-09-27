package com.main;

import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		DbConfig db = new DbConfig();
		Scanner sc = new Scanner(System.in);
		Student s = new Student();
		System.out.println("Welcome to the Student portal");
		while(true) {
			System.out.println("Main menu");
			System.out.println("Enter 1 for insert student");
			System.out.println("Enter 2 for update student");
			System.out.println("Enter 3 for delete student");
			System.out.println("Enter 4 for fetch all students");
			System.out.println("Enter 0 for exit");
			int input = sc.nextInt();
			if(input ==0 ) {
				break;
			}
			switch(input) {
				case 1:
					System.out.println("Enter student details....");
					System.out.println("Enter the student name");
					s.setName(sc.next());
					System.out.println("Enter the city");
					s.setCity(sc.next());
					System.out.println("Enter the age");
					s.setAge(sc.nextInt());
					db.insertStudent(s);
					System.out.println("Record saved sucessfully");
					break;
				case 2:
					System.out.println("Enter the Id of the student you want to update");
					int studId = sc.nextInt();
					s = db.fetchStudentById(studId);
					Student s1 = new Student();
					System.out.println("Previous data of student is \n "+s);
					System.out.println("Enter student details....");
					System.out.println("Enter the student name");
					s1.setName(sc.next());
					System.out.println("Enter the city");
					s1.setCity(sc.next());
					System.out.println("Enter the age");
					s1.setAge(sc.nextInt());
					db.updateStudent(s1,studId);
					System.out.println("Updated sucessfully");
 					break;
				case 3:
					System.out.println("Enter the Id of the student you want to delete");
					studId = sc.nextInt();
					s = db.fetchStudentById(studId);
					System.out.println("Data of student is \n "+s);
					System.out.println("Press 1 for delete \npress any key for cancel");
					int conf = sc.nextInt();
					if(conf==1) {
						db.deleteStudent(studId);
						System.out.println("Student record deleted sucessfully");
					}
					else {
						System.out.println("operation cancelled");
					}
					break;
				case 4:
					System.out.println("*******Student details****** ");
					System.out.println("id\tname\tcity\tage");
					List<Student> list = db.fetchAllStudent();
					for(Student stud :list) {
						System.out.println(stud.getId()+"\t"+stud.getName()+"\t"+stud.getCity()+"\t"+stud.getAge());
					}					
					break;
				default:
			
			}
		}
		sc.close();
	}
}
 