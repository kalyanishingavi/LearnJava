package com.main;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.main.studentService.StudentService;

public class App {
		public static void main(String[] args) throws SQLException {
			DBconnect connect = new DBconnect();
			System.out.println("Welcome to project");
			Scanner sc = new Scanner(System.in);
			Student s = new Student();
			while(true) {
				System.out.println("Press 1 for Insert");
				System.out.println("Press 2 for Delete");
				System.out.println("Press 3 for Update");
				System.out.println("Press 4 for fetching the data");
				System.out.println("Press 0 for exit");
				int input = sc.nextInt();
				if(input == 0) {
					System.out.println("Exiting bye");
					break;
				}
				switch(input) {
				case 1:
					
					System.out.println("Enter the name ");
					s.setName(sc.next());
					System.out.println("Enter the city");
					s.setCity(sc.next());
					System.out.println("Enter the age");
					s.setAge(sc.nextInt());
					System.out.println("Enter the department ID");
					s.setDepartmentID(sc.nextInt());
					connect.insertStudent(s);
					
					break;
					
				case 2:
					System.out.println("Deletion Operation");
					System.out.println("Enter the ID to delete");
					int id = sc.nextInt();
					connect.delete(id);
					break;
				
				case 3: 
					System.out.println("Update Operation");
					System.out.println("Enter the id to Update");
					id = sc.nextInt();
					Student student = connect.fetchStudentById(id);
					
					System.out.println("Data of student Id " + id+ "is like");
					System.out.println(student.getName() + "   " + student.getCity()+ "   " + student.getAge() + "   " + 
										student.getDepartmentID());
					
					System.out.println("Enter the details to update");
					System.out.println("Enter the name ");
					s.setName(sc.next());
					System.out.println("Enter the city");
					s.setCity(sc.next());
					System.out.println("Enter the age");
					s.setAge(sc.nextInt());
					System.out.println("Enter the department ID");
					s.setDepartmentID(sc.nextInt());
					connect.dbUpdate(s,id);
					break;
				
				case 4:
					System.out.println("All Students Record");
					System.out.println("****************************************");
					System.out.println("ID\tNAME\t\t\tCITY\tAGE\tDEPT_ID");
					System.out.println("------------------------------------------");
					List<Student> list = connect.fetchStudent();
					for(Student stud : list) {
						System.out.println(stud.getId()+"\t"+stud.getName()+"\t\t"+ stud.getCity()+"\t"
								+stud.getAge()+"\t"+stud.getDepartmentID());
					}
					
					System.out.println("****************************************");
					while (true) {
							System.out.println("*****Operation Menu*******");
							System.out.println("Press 1 for sort the record as per age");
							System.out.println("Press 2 for group the records by city");
							System.out.println("Press 3 for group record by department");
							System.out.println("Press 11 for exit");
							int opInput = sc.nextInt();
							if(opInput == 11) {
								System.out.println("Exiting bye");
								break;
							}
							StudentService studser = new StudentService();
							switch(opInput) {
								case 1: 
									System.out.println("*********Sorted List***************");
									System.out.println("ID\tNAME\t\t\tCITY\tAGE\tDEPT_ID");
									System.out.println("------------------------------------------");
									List<Student> sortedList = studser.sortByAge(list);
									for(Student stud : sortedList) {
										System.out.println(stud.getId()+"\t"+stud.getName()+"\t\t"+ stud.getCity()+"\t"
												+stud.getAge()+"\t"+stud.getDepartmentID());
									}
									
									System.out.println("****************************************");
									break;
								case 2 : 
									System.out.println("*********group record by city******");
									Map<String,Integer> groupCity = new LinkedHashMap<>();
									groupCity = connect.GroupByCity();
									System.out.println("City\t\tno_of_students");
									for(String k : groupCity.keySet()) {
										System.out.println(k + "\t\t" + groupCity.get(k));
									}
									
									break;
								case 3 :
									System.out.println("*********group record by city******");
									Map<String,Integer> groupDepartment = new LinkedHashMap<>();
									groupDepartment = connect.GroupByDepartment();
									System.out.println("No_of_Students\t\tDepartment_name");
									for(String k : groupDepartment.keySet()) {
										System.out.println(k + "\t\t" + groupDepartment.get(k));
									}
									break;
								default:
								
							}
					}
					break;
				default: System.out.println("Invalid Input please enter valid Input");

				
				}

			}
			sc.close();
			
}
}