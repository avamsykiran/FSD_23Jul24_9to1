package com.cts.jsf.ui;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cts.jsf.models.Contact;

public class App07StreamsDemo {

	public static void main(String[] args) {

		List<Contact> contacts = new ArrayList<>();

		contacts.add(new Contact(3, "Xavear", "9999999992", "vamsy@gmail.com", LocalDate.of(1984, Month.MAY, 12)));
		contacts.add(new Contact(4, "Abhiram", "9999999994", "vamsy@gmail.com", LocalDate.of(1983, Month.JANUARY, 12)));
		contacts.add(new Contact(8, "Chandra", "9999998880", "vamsy@gmail.com", LocalDate.of(1983, Month.JULY, 12)));
		contacts.add(new Contact(6, "Bheem", "9999999995", "vamsy@gmail.com", LocalDate.of(1980, Month.JULY, 12)));
		contacts.add(new Contact(5, "Diwakar", "9999999993", "vamsy@gmail.com", LocalDate.of(1982, Month.JULY, 12)));
		contacts.add(new Contact(7, "Edward", "9999999977", "vamsy@gmail.com", LocalDate.of(1988, Month.OCTOBER, 12)));
		contacts.add(new Contact(2, "Zeenath", "9999999991", "vamsy@gmail.com", LocalDate.of(1987, Month.JUNE, 12)));
		contacts.add(new Contact(9, "Tanvi", "9101010109", "vamsy@gmail.com", LocalDate.of(1985, Month.DECEMBER, 12)));
		contacts.add(new Contact(1, "Vamsy", "9999999999", "vamsy@gmail.com", LocalDate.of(1985, Month.JULY, 12)));

		contacts.stream().forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------");
		
		contacts.stream().forEach( c -> {
			c.setMobile("(0091) "+c.getMobile());
		});
		
		contacts.stream().forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------");
		
		Optional<Contact> result = 
				contacts.stream().reduce( (c1,c2) -> c1.getDateOfBirth().isAfter(c2.getDateOfBirth()) ? c1:c2 );
		
		if(result.isPresent()) {
			System.out.println(result);
		}
		
		System.out.println("---------------------------------------------------------------------");
		
		contacts.stream().filter( c -> c.getMobile().endsWith("9")).forEach(System.out::println);
		
		System.out.println("---------------------------------------------------------------------");
		
		contacts.stream()
			.map( c -> String.format("Hello %s, we will call you on %s soon", c.getFullName(),c.getMobile()) )
			.forEach(System.out::println);
		
		System.out.println("---------------------------------------------------------------------");
	}
}
