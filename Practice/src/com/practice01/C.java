package com.practice01;

abstract public class C extends B{
	public void view(Student[] s) {
		int i =0 ;
		System.out.println("Id\tName\tCity");
		while(s[i].getName() != null) {
			System.out.println(s[i].getId()+"\t"+s[i].getName()+"\t"+s[i].getCity());
			i++;
		}
	}
}
