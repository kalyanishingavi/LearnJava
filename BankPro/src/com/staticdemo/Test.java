package com.staticdemo;
import static com.staticdemo.C.x;
import static com.staticdemo.C.display;
public class Test {
	public static void main(String[] args) {
		C1 c = new C1();
		c.x= 100;
		c.y=200;
		C1 c1 = new C1();
		System.out.println(c.x);
		System.out.println(c1.x);
		System.out.println(c.y);	
		System.out.println(c1.y);
		
		System.out.println(x);
		display();
	}
}

class C1{
	int x =10;
	static int y = 20;
}