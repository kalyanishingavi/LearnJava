package com.collectionframwork;
import java.util.*;
public class HashcodeDemo {

		public static void main(String[] args) {
			
			Set<Integer> myset = new TreeSet<>();
			myset.add(10);
			myset.add(3);
			myset.add(23);
			myset.add(123);
			myset.add(3);// it negelcts the duplicates
			//set.add(null); gives Null pointer Exception
			
			System.out.println(myset);
			
			for(int str : myset) {
				System.out.println(str);
			}
			
			EmployeeComparable e1 = new EmployeeComparable(3,"Gaurav Lavand",75000,"MAGIC");
			EmployeeComparable e2 = new EmployeeComparable(1,"Ramdas Rathod",125000,"STATIC");
			EmployeeComparable e3 = new EmployeeComparable(4,"Sid Potdar",100000,"PARLE");
			EmployeeComparable e4 = new EmployeeComparable(2,"Vivek katore",98000,"T20");
			EmployeeComparable e5 = new EmployeeComparable(2,"Vivek katore",98000,"T20");
			Set<EmployeeComparable> set = new HashSet<>();
			set.add(e1);
			set.add(e2);
			set.add(e3);
			set.add(e4);
			set.add(e5);
		
			for(EmployeeComparable e : set) {
				System.out.println(e);
			}
			
			
	}

}
