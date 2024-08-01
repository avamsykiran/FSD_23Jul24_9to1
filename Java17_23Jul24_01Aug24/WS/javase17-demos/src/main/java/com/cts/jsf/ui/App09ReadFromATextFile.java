package com.cts.jsf.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.cts.jsf.models.Contact;

public class App09ReadFromATextFile {

	public static void main(String[] args) {

		String fileName = "contacts.csv";

		Path filePath = Paths.get(fileName);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		try {
			List<String> lines = Files.readAllLines(filePath);
			
			List<Contact> contacts =
					 lines.stream()
							.map(line -> {
								String[] fields = line.split(",");
								return new Contact(
										Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], 
										LocalDate.parse(fields[4],dtf));
							})
							.collect(Collectors.toList());
			
			contacts.stream().forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
