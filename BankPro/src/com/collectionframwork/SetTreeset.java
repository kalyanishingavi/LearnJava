package com.collectionframwork;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
public class SetTreeset {
	public static void main(String[] args) {
		
		Set<String> set = new TreeSet<>();
		set.add("Vivek");
		set.add("Sid");
		set.add("Ram");
		set.add("Gaurav");
		set.add("Vivek");// it negelcts the duplicates
		//set.add(null); gives Null pointer Exception
		
		System.out.println(set);
		
		for(String str : set) {
			System.out.println(str);
		}
		List<String> lst = new ArrayList<>();
		lst.add("Abc");
		lst.add("Abc");
		System.out.println(lst);
		System.out.println("");
		
		Set<String> s = new TreeSet<>(lst);
		
		for(String str : s) {
			System.out.println(str);
		}
		
		
	}
}
