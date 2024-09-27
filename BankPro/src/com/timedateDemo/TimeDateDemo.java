package com.timedateDemo;
import java.util.Date;
import java.time.*;
public class TimeDateDemo {
	public static void main(String[] args) {
		System.out.println("-------To display date time in simple format------");
		Date date = new Date();
		System.out.println(date);
		
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("-----Current Date and Time---------");
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		
		System.out.println("--------Custom date and Time-------");
		
		LocalDate ld1 = LocalDate.of(2020, Month.JANUARY, 1);
		LocalTime lt1 = LocalTime.of(20, 33, 22);
		LocalDateTime ldt1 = LocalDateTime.of(2020, Month.APRIL, 21, 11, 33);
		
		System.out.println(ld1);
		System.out.println(lt1);
		System.out.println(ldt1);
		
		System.out.println("--------Manipulating date and Time-------");
		LocalDate ld2 = LocalDate.now().plusDays(2);
		System.out.println(ld2);
		LocalDate ld3 = LocalDate.now().minusDays(2);
		System.out.println(ld3);
		
		System.out.println("--------Coustomizing date and Time-------");
		LocalDate ld4 = LocalDate.now().withDayOfMonth(12).withYear(2020);
		System.out.println(ld4);
	}
	
	
}
