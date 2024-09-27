package com.enumDemo;

enum College{
	ABC,XYZ,PQR;
}
public class App {
	public static void main(String[] args) {
		
		College c = College.ABC;
		System.out.println(c);
		
		System.out.println("\n\n********************\n");
		
		String clgName = College.PQR.toString();
		System.out.println(clgName);
		System.out.println("\n\n********************\n");
		
		String p = "PQR";
		College c1 = College.valueOf(p);
		System.out.println(c1);
	}
}