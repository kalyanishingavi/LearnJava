package com.timedateDemo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDurationChrono {
	public static void main(String[] args) {
		
		LocalDate ld1 = LocalDate.now();
		LocalDate ld2 = LocalDate.of(2022, Month.JANUARY, 10);
		System.out.println("------Using Period class-------");
		int days = Period.between(ld2, ld1).getDays();
		int mons = Period.between(ld2, ld1).getMonths();
		System.out.println(days);
		System.out.println(mons);
		
		System.out.println("----------Using Chrono----------");
		long d = ChronoUnit.DAYS.between(ld2, ld1);
		long m = ChronoUnit.MONTHS.between(ld2, ld1);
		System.out.println(d);
		System.out.println(m);

		LocalTime lt1 = LocalTime.now();
		LocalTime lt2 = LocalTime.of(10, 30);
		System.out.println("------Using Duration class-------");
		long h = Duration.between(lt2, lt1).toHours();
		long min = Duration.between(lt2, lt1).toMinutes();
		System.out.println(h);
		System.out.println(min);
		
		System.out.println("----------Using Chrono----------");
		long h1 = ChronoUnit.MINUTES.between(lt2, lt1);
		long m1 = ChronoUnit.HOURS.between(lt2, lt1);
		System.out.println(h1);
		System.out.println(m1);

	}
}
