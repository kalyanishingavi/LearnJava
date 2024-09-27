package com.main;

import java.sql.SQLException;

public class App {
		public static void main(String[] args) {
			Student s = new Student(1,"Gaurav","Baramati",22,2);
			
			DBsss connect = new DBsss();
			connect.insertStudent(s);
			System.out.println("Inserted successfully");
			
			
		}
}
