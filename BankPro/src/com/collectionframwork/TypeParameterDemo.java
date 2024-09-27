package com.collectionframwork;

public class TypeParameterDemo {
	public static void main(String[] args) {
		
		X x = new X();
		Integer[] i = new Integer[] { 1,3,3,4,2};
		Float[] f = new Float[] {1.0f,4.5f,2.5f};
		String[] s = new String[] {"abc","lmn","sss"};
		x.display(i);
		x.display(f);
		x.display(s);
		/*
		 * Type parameter does not work with primitive data types
		 * int[] i = new int[];  does not work
		 * We have to use wrapper class array that JVM can use in the run time
		 * and attach it directly to the T class
 		 */
	}
}

class X{
	<T> void display(T[] t){
		for(T temp : t) {
			System.out.print(temp + " ");
		}
		System.out.println();
	}
}