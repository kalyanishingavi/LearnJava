package com.collectionframwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppListClassComparable {
	public static void main(String[] args) {
		EmployeeComparable e1 = new EmployeeComparable(1,"Gaurav Lavand",75000,"MAGIC");
		EmployeeComparable e2 = new EmployeeComparable(2,"Ramdas Rathod",125000,"STATIC");
		EmployeeComparable e3 = new EmployeeComparable(3,"Sid Potdar",100000,"PARLE");
		EmployeeComparable e4 = new EmployeeComparable(4,"Vivek katore",98000,"T20");
		
		List<EmployeeComparable> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		System.out.println("******Before Sorting*******\n");
		for(EmployeeComparable e : list) {
			System.out.println(e);
		}
		
		Collections.sort(list);
		
		System.out.println("\n******Before Sorting*******\n");
		for(EmployeeComparable e : list) {
			System.out.println(e);
		}
		
	}
	
	
	
}
