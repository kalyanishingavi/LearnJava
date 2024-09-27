package com.collectionframwork;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		
		Queue<String> queue = new PriorityQueue<>();
		
		queue.add("lmn");
		queue.add("abc");
		queue.add("pqr");
		
		System.out.println(queue);
		
		System.out.println("------Peek first element of the queue-------");
		System.out.println(queue.peek());
		
		System.out.println("---Poll---remove and print first element");
		System.out.println(queue.poll());
		System.out.println(queue);
		
		System.out.println("-----Remove an element------");
		queue.remove("lmn");
		System.out.println(queue);
		
		System.out.println("-------Searching an element-------");
		boolean check = queue.contains("pqr");
		System.out.println(check?"Found":"Not Found");
		
		System.out.println("-----Advanced for each loop-----");
		queue.forEach(System.out :: println);
		
		System.out.println("-------Remove methods------");
		//queue.removeAll(queue);
		queue.clear();
		System.out.println(queue);
		
	}
}
