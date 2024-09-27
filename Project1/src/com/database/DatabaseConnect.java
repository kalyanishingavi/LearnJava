package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	private String user = "root";
	private String pass = "";
	private String url = "jdbc:mysql://localhost:3306/project";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	Connection conn;
	
	public void dbconnect() {
		try {
			Class.forName(driver);
			System.out.println("driver connected");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver load error");
		}
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println("Connection error");
			e.printStackTrace();
		}
		
	}
	
	public void dbclose() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Database close error");
			e.printStackTrace();
		}
	}

	public void fetchAllRecord() {
		dbconnect();
		
		dbclose();
		
	}
	
	
	
}
