package com.collectionframwork;

import java.util.*;

public class ArrayListClassDemo {
	public static void main(String[] args) {
		Employee e1 = new Employee(1,"Gaurav Lavand",75000,"MAGIC");
		Employee e2 = new Employee(2,"Ramdas Rathod",125000,"STATIC");
		Employee e3 = new Employee(3,"Sid Potdar",100000,"PARLE");
		Employee e4 = new Employee(4,"Vivek katore",98000,"T20");
		
		List<Employee> list = new ArrayList<>();
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		System.out.println("******Collection Sorting******\n");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Ascending\n2.Decending\n0.Exit\n");
			int input = sc.nextInt();
			if(input == 0 )
				break;
			switch(input) {
			case 1:
				System.out.println("\n******DATA SET******\n");
				for(Employee e : list) {
						System.out.println(e);
					}
					System.out.println("\n******After Ascending Sorting ******\n");
					
					Collections.sort(list,new A());
					
					for(Employee e : list) {
						System.out.println(e);
					}
					break;
			case 2:
				System.out.println("\n******DATA SET******\n");
				for(Employee e : list) {
						System.out.println(e);
					}
					System.out.println("\n******After Decending Sorting ******\n");
					
					Collections.sort(list,new B());
					
					for(Employee e : list) {
						System.out.println(e);
					}
					break;
			default: System.out.println("Inalid Input");
			}
		}
		
		
		
	}
}
/*
 * Comparator rules of return statement
 * +ve : swap
 * 0 : same do nothing
 * -ve : As per the order do nothing
 */
class A implements Comparator<Employee>{
	
	public int compare(Employee e1,Employee e2) { // 75000 > 45000
		if(e1.getSalary() > e2.getSalary())
			return 1;
		if(e1.getSalary() == e2.getSalary())
			return 0;
		return -1;
	}
}

class B implements Comparator<Employee>{
	public int compare(Employee e1,Employee e2) {
		if(e1.getSalary() < e2.getSalary())
			return 1;
		if(e1.getSalary() > e2.getSalary())
			return -1;
		return 0;
	}
}
