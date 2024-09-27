package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DBsss {

	/*
	 * Step 1: Declare all DB Variables
	 */
	private String userDB="root";
	private String passDB="";
	private String url="jdbc:mysql://localhost:3306/collegedb";
	private String driver="com.mysql.cj.jdbc.Driver";
	
	private Connection conn;
	
	public void dbConnect() {
		//Load the Driver
		try {
			Class.forName(driver);
			System.out.println("driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading issue..");
			e.printStackTrace();
		}
		//establish the connection 
		try {
			conn = DriverManager.getConnection(url, userDB, passDB);
			System.out.println("conn made " + conn);
		} catch (SQLException e) {
			System.out.println("DB Connection Issue..");
			e.printStackTrace();
		} 
	}
	
	public void dbClose() {
		try {
			conn.close();
			System.out.println("conn closed");
		} catch (SQLException e) {
			System.out.println("DB Close Issue...");
			e.printStackTrace();
		}
	}
	
	public void insertStudent(Student s)   {
		dbConnect();
		String sql="insert into student(name,city,age,dept_id) values (?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getCity());
			pstmt.setInt(3, s.getAge());
			pstmt.setInt(4, s.getDepartmentID());
			
			/*
			 * executeQuery() : select 
			 * executeUpdate() : insert, delete, update/edit
			 */
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dbClose();
	}
}
