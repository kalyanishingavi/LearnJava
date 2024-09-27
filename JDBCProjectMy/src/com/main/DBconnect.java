package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBconnect {
	
	// Declare all the Database variables
	private String user = "root";
	private String pass= "";
	private String url = "jdbc:mysql://localhost:3306/collegedb";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private Connection conn;
	
	public void dbconnect() {
		// load the driver
		try {
			Class.forName(driver);
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loaded error");
			e.printStackTrace();
		}
		//establishing the connection
		
		try {
			System.out.println("Connecting");
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("Connection established");
		} catch (SQLException e) {
			System.out.println("Connection falied");
			e.printStackTrace();
		}
		
	}
	
	public void dbclose() {
		try {
			System.out.println("DB closed successfully");
			conn.close();
		} catch (SQLException e) {
		System.out.println("DB close error");
			e.printStackTrace();
		}
	}
	
	public void insertStudent(Student s) throws SQLException {
		dbconnect();
		
		String sql = "insert into student(name,city,age,dept_id) values (?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql); 
		psmt.setString(1, s.getName()); 
		psmt.setString(2, s.getCity());
		psmt.setLong(3, s.getAge());
		psmt.setLong(4, s.getDepartmentID());
		
		psmt.executeUpdate(sql);
		dbclose();
	}

	
}
