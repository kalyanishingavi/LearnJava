package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbConfig {

	private String username="root";
	private String password="";
	private String url = "jdbc:mysql://localhost:3306/Abc";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private Connection conn;
	public void Dbconnect() {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver connection issue");
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Connection issue");
			e.printStackTrace();
		}
	}
	
	
	public void Dbclose() {
		
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("dbclose issue");
			e.printStackTrace();
		}
	}


	public void insertStudent(Student s) {
		Dbconnect();
		String sql = "insert into student(name,city,age) values(?,?,?)";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, s.getName());
			psmt.setString(2, s.getCity());
			psmt.setInt(3, s.getAge());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL query issue");
			e.printStackTrace();
		}
		
		Dbclose();
		
	}


	public Student fetchStudentById(int studId) {
		Dbconnect();
		Student student = new Student();
		String sql = "select * from student where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studId);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				student.setName(rst.getString("name"));
				student.setCity(rst.getString("city"));
				student.setAge(rst.getInt("age"));
				student.setId(rst.getInt("id"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL query issue");
			e.printStackTrace();
		}
		Dbclose();
		return student;
	}


	public void updateStudent(Student s1, int studId) {
		Dbconnect();
		String sql = "update student SET name=? , city = ? , age =? where id =?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s1.getName());
			pstmt.setString(2, s1.getCity());
			pstmt.setInt(3, s1.getAge());
			pstmt.setInt(4,studId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL query issue");
			e.printStackTrace();
		}
		Dbclose();
	}


	public void deleteStudent(int studId) {
		Dbconnect();
		String sql = "delete from student where id = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL query issue");
			e.printStackTrace();
		}
		Dbclose();
		
	}


	public List<Student> fetchAllStudent() {
		Dbconnect();
		String sql = "select * from student";
		List<Student> list = new ArrayList<>();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rst =pstmt.executeQuery();
			while(rst.next()) {
				Student s = new Student();
				s.setId(rst.getInt(1));
				s.setName(rst.getString(2));
				s.setCity(rst.getString(3));
				s.setAge(rst.getInt(4));
				list.add(s);
			}
		} catch (SQLException e) {
			System.out.println("SQL query issue");
			e.printStackTrace();
		}
		
		Dbclose();
		return list;
	}
	

}
