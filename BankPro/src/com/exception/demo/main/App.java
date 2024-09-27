package com.exception.demo.main;

import com.exception.demo.main.beans.Customer;
import com.exception.demo.main.exceptions.InvalidFundsExceptions;
import com.exception.demo.main.exceptions.OverTheLimitException;
import com.exception.demo.main.service.B;

public class App {
		public static void main(String[] args) {
		Customer c = new Customer("Gaurav",30000);
		Customer c1 = new Customer("Ramdas",20000);
		
		B b = new B();
		
		b.deposit(c, 40000);
		b.deposit(c1, 40000);
		
		try {
			b.withdraw(c,54000);
			
		}
		catch(OverTheLimitException e) {
			System.out.println(e.display());
		}
		catch(InvalidFundsExceptions e) {
			System.out.println(e.display());
		}
		catch(RuntimeException e) {
			System.out.println("Operation could not be done this time");
		}
		
		finally {
			b = null;
		}
		
	}
}
