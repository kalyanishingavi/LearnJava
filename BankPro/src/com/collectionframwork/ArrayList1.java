package com.collectionframwork;

import java.util.ArrayList;
import java.util.List;
public class ArrayList1 {
	public static void main(String[] args) {
		
		// Arraylist is alternative to arrays
		
		// way 1 to create the arraylist
		ArrayList list1 = new ArrayList();
		
		// way 2 by using polymorphic object
		
		// List list = new List();   // CF as list is an interface we cannot create object of it
		
		List list = new ArrayList(); // Preferred and Raw list
		// List should be restricted to a particular type
		
		list.add(1);
		list.add(1.0f);
		list.add("str");
		System.out.println(list);
		
		List<Integer> lst = new ArrayList<>();// generic way
		// arrayList is restricted to the interger type only
		
		lst.add(12);
		lst.add(1);
		//lst.add("str"); CF- as arraylist is restricetd to only Interger 
		
		System.out.println(lst);
		
	}
}
