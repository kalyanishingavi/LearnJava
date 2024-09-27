package com.concurrentHaspMap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class App4 {
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(3);
		deque.offer(1);
		deque.offer(4);
		//deque.offer(null); It throws null pointer exception
		
		deque.addFirst(10);
		System.out.println(deque);
		
		Deque<Integer> deque1 = new LinkedList<>();
		deque1.offer(3);
		deque1.offer(1);
		deque1.offer(4);
		deque1.offer(null); //It accepts null values
		
		deque1.addFirst(10);
		System.out.println(deque1);
		
		Deque<Integer> deque2 = new ConcurrentLinkedDeque<>();
		deque2.offer(3);
		deque2.offer(1);
		deque2.offer(4);
		deque2.addFirst(10);
		Iterator<Integer> itr = deque2.descendingIterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + "   ");
		}
	}
}
