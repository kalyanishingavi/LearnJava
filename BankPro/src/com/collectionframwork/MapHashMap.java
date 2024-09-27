package com.collectionframwork;

import java.util.HashMap;
import java.util.Map;

public class MapHashMap {
	public static void main(String[] args) {
		
		Map<String,String> m = new HashMap<>();
		
		m.put("Gaurav","lavand");
		m.put("Sid", "Potdar");
		m.put("Ram", "Rathod");
		// Searching using key
		System.out.println("******Searching using Key***********");
		String psw = m.get("Gaurav");
		System.out.println(psw);
		
		//printing key set
		System.out.println("\n******Key set********\n");
		for(String key: m.keySet()) {
			System.out.println(key);
		}
		
		//printing Values set
			System.out.println("\n******Values set********\n");
		for(String key: m.values()) {
			System.out.println(key);
		}
		
		//Loopung in map
		System.out.println("\n********Looping through map*********\n");
		for(Map.Entry<String, String> map : m.entrySet()) {
			System.out.println(map.getKey() + "--"+map.getValue());
		}
		
		// Searching
		System.out.println("\n*******Searcing of key *******\n");
		boolean status = m.containsKey("Gaurav");
		System.out.println(status?"Present":"Absent");
		
		System.out.println("\n*******Searcing of Values *******\n");
		status = m.containsValue("lavand");
		System.out.println(status?"Present":"Absent");
	}
}
