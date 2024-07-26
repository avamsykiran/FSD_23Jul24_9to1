package com.cts.jsf.ui;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.cts.jsf.models.Contact;

public class App05MapDemo {

	public static void main(String[] args) {

				
		Set<Contact> contacts= new HashSet<>();

		contacts.add(new Contact(3, "Xavear", "9999999992", "vamsy@gmail.com", LocalDate.of(1984, Month.MAY, 12)));
		contacts.add(new Contact(4, "Abhiram", "9999999994", "vamsy@gmail.com", LocalDate.of(1983, Month.JANUARY, 12)));
		contacts.add(new Contact(8, "Chandra", "9999998880", "vamsy@gmail.com", LocalDate.of(1983, Month.JULY, 12)));
		contacts.add(new Contact(6, "Bheem", "9999999995", "vamsy@gmail.com", LocalDate.of(1980, Month.JULY, 12)));
		contacts.add(new Contact(5, "Diwakar", "9999999993", "vamsy@gmail.com", LocalDate.of(1982, Month.JULY, 12)));
		contacts.add(new Contact(7, "Edward", "9999999977", "vamsy@gmail.com", LocalDate.of(1988, Month.OCTOBER, 12)));
		contacts.add(new Contact(2, "Zeenath", "9999999991", "vamsy@gmail.com", LocalDate.of(1987, Month.JUNE, 12)));
		contacts.add(new Contact(9, "Tanvi", "9101010109", "vamsy@gmail.com", LocalDate.of(1985, Month.DECEMBER, 12)));
		contacts.add(new Contact(1, "Vamsy", "9999999999", "vamsy@gmail.com", LocalDate.of(1985, Month.JULY, 12)));

		Map<Month,Integer> monthWiseContacts = new TreeMap<>();
		
		for (Contact c : contacts) {
			Month m = c.getDateOfBirth().getMonth();
			if(monthWiseContacts.containsKey(m)) {
				monthWiseContacts.replace(m, monthWiseContacts.get(m)+1);
			}else {
				monthWiseContacts.put(m, 1);
			}
		}
		
		System.out.println(monthWiseContacts);
		
	}

}
