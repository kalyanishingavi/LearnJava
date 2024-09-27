package com.collectionframwork;
import java.util.*;
public class ArrayList2 {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(3);
		list.add(6);
		list.add(1);
		
		System.out.println(list);
		//Iterate through list using for loop
		System.out.println("\n*****Interration using for-Each loop******");
		
		for(int i : list) {
			System.out.print(i + "  ");
		}
		
		//Iterate in list using iterator interface
		System.out.println("\n*****Iteration using Iterator******");
		
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + "  ");
		}
		
		// Sorting of list
		System.out.println("\n******Sorting of list*******");
		Collections.sort(list);
		System.out.println(list);
		
		// Get the indexed element
		System.out.println("*******Get the indexed Element********");
		/*
		 * If we go beyond the limit of list it will throw an IndexOutOfBoundException
		 */
		int ele = list.get(3);
		System.out.println("3rd element " +ele);
		
		// Remove an element
		System.out.println("*******Remove an element*******");
		list.remove(2);
		System.out.println("After removing 2nd element\n" + list);
		
		//Searching
		System.out.println("******Contains methos to search an element********");
		boolean check = list.contains(12);
		System.out.println(check?"Element present" : "Not Present");
		
		//Sublist
		List<Integer> lst = list.subList(1, 3);
		for(int i : lst) {
			System.out.print(i+" ");
		}
	}
}
