package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loaded error");
			e.printStackTrace();
		}
		//establishing the connection
		
		try {
			conn = DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			System.out.println("Connection falied");
			e.printStackTrace();
		}
		
	}
	
	public void dbclose() {
		try {
			conn.close();
		} catch (SQLException e) {
		System.out.println("DB close error");
			e.printStackTrace();
		}
	}
	
	public void insertStudent(Student s)  {
		dbconnect();
		
		String sql = "insert into student(name,city,age,dept_id) values (?,?,?,?)";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, s.getName()); 
			psmt.setString(2, s.getCity());
			psmt.setLong(3, s.getAge());
			psmt.setLong(4, s.getDepartmentID());
			psmt.executeUpdate();
			System.out.println("Inserted successfully");
		} catch (SQLException e) {
			System.out.println("Insertion error");
			e.printStackTrace();
		} 
		
		dbclose();
	}

	public void delete(int id) {
		dbconnect();
		String sql = "delete from student where id = ?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		
			System.out.println("Deleted Successfully");
		} catch (SQLException e) {
			System.out.println("Deletion error");
			e.printStackTrace();
		}
		
		dbclose();
	}

	public Student fetchStudentById(int id) {
		dbconnect();
		Student s = new Student();
		String sql = "select * from student where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				String name = rst.getString("name");
				String city = rst.getString("city");
				int age = rst.getInt("age");
				int departmentId = rst.getInt("dept_id");
				s.setName(name);
				s.setCity(city);
				s.setAge(age);
				s.setDepartmentID(departmentId);
			}
		} catch (SQLException e) {
			System.out.println("Query not detected");
			e.printStackTrace();
		}
		dbclose();
		return s;
	}

	public void dbUpdate(Student s, int id) {
		dbconnect();
		String sql = "update student SET name = ? ,city = ? , age = ? , dept_id = ? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getCity());
			pstmt.setInt(3, s.getAge());
			pstmt.setInt(4, s.getDepartmentID());
			pstmt.setInt(5, id);
			
			pstmt.executeUpdate();
			System.out.println("Updated successfully");
			
		} catch (SQLException e) {
			System.out.println("SQL query issue");
			e.printStackTrace();
		}
		
		dbclose();
		
	}

	public List<Student> fetchStudent() {
		dbconnect();
		List<Student> list = new ArrayList<>();
		String sql = "select * from student";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			ResultSet rst = psmt.executeQuery();
			while(rst.next()) {
				int id = rst.getInt("id");
				String name = rst.getString("name");
				String city = rst.getString("city");
				int age = rst.getInt("age");
				int did = rst.getInt("dept_id");
				
				Student s = new Student(id,name,city,age,did);
				list.add(s);
			}
		} catch (SQLException e) {
			System.out.println("SQL query error");
			e.printStackTrace();
		}
		
		
		
		dbclose();
		return list;
	}

	public Map<String, Integer> GroupByCity() {
		dbconnect();
		Map<String,Integer> map = new LinkedHashMap<>();
		String sql = "select city,count(id) as cnt from student group by city order by cnt DESC";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rst = psmt.executeQuery();
			while(rst.next()) {
				String city = rst.getString(1);
				int count = rst.getInt(2);
				map.put(city, count);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error");
			e.printStackTrace();
		}
		
		
		dbclose();
		return map;
	}

		
	public Map<String, Integer> GroupByDepartment() {
		dbconnect();
		Map<String,Integer> map = new LinkedHashMap<>();
		String sql = "select count(s.id) as cnt, d.name from student s,department d group by "
				+ "d.name order by cnt DESC";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rst = psmt.executeQuery();
			while(rst.next()) {
				String city = rst.getString(1);
				int count = rst.getInt(2);
				map.put(city, count);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error");
			e.printStackTrace();
		}

		dbclose();
		return map;
	}

	
}
