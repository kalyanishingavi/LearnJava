package com.concurrentHaspMap;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class App1 {
public static void main(String[] args) {
		
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		
		map.put(1, "harry");
		map.put(4, "draco");
		map.put(2, "ron");
		
		map.putIfAbsent(2,"Hermoine"); // key 2 is present so it will not add another entry for key 2
		map.putIfAbsent(3,"Hermoine");
		
		for(Entry<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() +" ---- " + m.getValue());
		}
		
		System.out.println("------------------------");
		map.forEach((k,v) -> System.out.println(k + " ---- " + v));
		
		System.out.println("------------------------");
		
		map.compute(5, (k,v) -> k>4?"snape":null);
		
		map.compute(5, (k,v) -> k>map.size()?"dumbledoor":null);
		// here key value of key 5 will be null and it will not give the error but it will not 
		// display the value
		System.out.println(map);
		
		map.compute(5, (k,v) -> k>map.size()?"dumbledoor":v);
		System.out.println(map);
		
		
	}
}
