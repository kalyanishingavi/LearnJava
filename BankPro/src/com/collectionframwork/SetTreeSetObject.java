package com.collectionframwork;

import java.util.Set;
import java.util.TreeSet;

public class SetTreeSetObject {
	public static void main(String[] args) {
		EmployeeComparable e1 = new EmployeeComparable(3,"Gaurav Lavand",75000,"MAGIC");
		EmployeeComparable e2 = new EmployeeComparable(1,"Ramdas Rathod",125000,"STATIC");
		EmployeeComparable e3 = new EmployeeComparable(4,"Sid Potdar",100000,"PARLE");
		EmployeeComparable e4 = new EmployeeComparable(2,"Vivek katore",98000,"T20");
		
		Set<EmployeeComparable> set = new TreeSet<>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		
	
		for(EmployeeComparable e : set) {
			System.out.println(e);
		}
	}
}
