package com.concurrentHaspMap;

import java.util.concurrent.ConcurrentHashMap;

public class App {
	public static void main(String[] args) {
		
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		
		map.put(1, "harry");
		map.put(4, "draco");
		map.put(2, "ron");
		
		map.putIfAbsent(2,"Hermoine"); // key 2 is present so it will not add another entry for key 2
		map.putIfAbsent(3,"Hermoine");// key 3 is not present so it will add the entry
		
		System.out.println(map);

		// put will replace the exixting value with new value
		map.put(1, "snape");
		System.out.println(map);
		
		// replace will also replace the exixting value with new value
		
		map.replace(1, "snape", "harry");
		System.out.println(map);
		
		//removal of value
		map.remove(4);
		System.out.println(map);
		
		//removes all the entry of map
		map.clear();
		System.out.println(map);
	}
}
