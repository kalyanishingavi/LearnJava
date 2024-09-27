package com.collectionframwork;

import java.util.*;
public class MapTreeNavigationMap {
	public static void main(String[] args) {
		NavigableMap<Integer,String> map = new TreeMap();
		
		map.put(1000, "Gaurav");
		map.put(7484, "Sid");
		map.put(123,  "Ramdas");
		map.put(345,  "Viverk");
		map.put(2350, "Akash");
		map.put(4632, "Sagar");
		map.put(234,  "Sachin");
		//Default prints map is asending order of keys
		System.out.println(map);
		
		//Printing decending order of keys
		
		System.out.println(map.descendingKeySet());
		
		//printing decending map
		
		System.out.println(map.descendingMap());
		//Printing first entry
		System.out.println(map.firstEntry());
		//printing last entry
		System.out.println(map.lastEntry());
		
		// Poll/delete first entry
		
		System.out.println(map.pollFirstEntry());
		
		// Poll/delete last entry
		System.out.println(map.pollLastEntry());
		System.out.println(map);
	}
}
