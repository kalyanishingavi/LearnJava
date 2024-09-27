package com.p2;
//import com.p1.A;
import com.p1.Customer;
import com.p3.D;
public class App {
	public static void main(String[] args) {
		/*A a = new A();
		a.display();
		
		a.sum(12,5);
		
		int result = a.compute(5);
		System.out.println("Result = "+result);
		
		a.m1(12,5);
		int val = a.m2();
		System.out.println("Sum is "+ val);
		
		int percent = a.computeResult(83,100);
		System.out.println("You secured "+ percent);
		
		B b = new B();
		B b1 = new B();
		
		System.out.println(b.i);
		b.i =10;
		System.out.println(b.i);
		
		System.out.println(b1.i);
		b1 = b;
		System.out.println(b1.i);
		*/
		Customer C1 = new Customer();
		C1.balance = 1000;
		C1.balance= C1.deposit(5000);
		System.out.println(C1.balance);
		
		Customer C2 = new Customer();
		C2.balance= C2.deposit(3000);
		System.out.println(C2.balance);
		
		D d = new D();
		D d1 = new D();
		d.x = 12;
		d1 = d;
		System.out.println(d.x);
		System.out.println(d1.x);
		d.x = 16;
		
		System.out.println(d1.x);
}

}