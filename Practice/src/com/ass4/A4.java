package com.ass4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class A4 {
	public static void main(String[] args) {
		employeeAdd e = new employeeAdd();
		/* calling method to add the employee details by giving the inputs 
		 as per int id,String name,String address,int salary
		 */
		boolean check =  e.saveEmployeeDetails(1,"Gaurav","Pune", 30000);
		System.out.println(check?"Insertion done" : "Insertion not done");
	}

}
class employeeAdd{
	// Creating variables for store database connection deatils
	private String Username = "postgres";
	private String Password = "root";
	private String URL = "jdbc:postgres://localhost:5432/demodb";
	
	private Connection conn;
	
	// Method for adding the details in the database
	boolean saveEmployeeDetails(int id,String name,String address,int salary) {
		// loading the Driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return false;
		}
		
		// establishing the connection according to the database details
		try {
			conn = DriverManager.getConnection(URL,Username,Password);
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
		
		// Inserting details in the database as per the record
		String sql = "insert into student values (?,?,?,?)";
		PreparedStatement psmt;
		try {
			// Prepare statement for inserting query to databse
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id); 
			psmt.setString(2, name);
			psmt.setString(3, address);
			psmt.setInt(4, salary);
			
			// Executing the query
			psmt.executeUpdate(sql);
			
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		} 
		
		// Closing the database connection 
		try {
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return true;
	}
}