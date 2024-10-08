package com.cts.jsf.ui;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class App02DateTimeApiDemo {

	public static void main(String[] args) {

		LocalTime starttime = LocalTime.now();
		
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		
		LocalDate today = LocalDate.now();
		
		//LocalDate indDay = LocalDate.of(1947, Month.AUGUST, 15);
		//LocalDate indDay = LocalDate.parse("1947-08-15"); //ISO Date Format
		LocalDate indDay = LocalDate.parse("15-Aug-1947",f1); //dd-MMM-yyyy
		
		Period indPeriod = Period.between(indDay, today);
		
		System.out.println(today.format(f1));
		System.out.println(indDay.format(f1));
		System.out.printf("Its been %d Yeras %d months and %d days that we got our independenc",
				indPeriod.getYears(),indPeriod.getMonths(),indPeriod.getDays());
		
		LocalDateTime dateTime = LocalDateTime.now();
		
		String[] formats = new String[] {
				"dd-MM-yy","dd-MMM-yyyy","dd-MMMM-yyyy","dd-MM-yy hh:mm:ss a",
				"dd-MM-yy HH:mm:ss"
		};
		
		for(String format : formats) {
			System.out.println(dateTime.format(DateTimeFormatter.ofPattern(format)));	
		}
		
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh:mm B");
		
		System.out.println(LocalTime.of(9, 30).format(f2));
		System.out.println(LocalTime.of(12, 30).format(f2));
		System.out.println(LocalTime.of(14, 30).format(f2));
		System.out.println(LocalTime.of(19, 30).format(f2));
		
		LocalTime endtime = LocalTime.now();
		Duration execDur = Duration.between(starttime, endtime);
		System.out.printf("\nIt took %d milli secs to execute this app.", execDur.toMillis());
	}

}
