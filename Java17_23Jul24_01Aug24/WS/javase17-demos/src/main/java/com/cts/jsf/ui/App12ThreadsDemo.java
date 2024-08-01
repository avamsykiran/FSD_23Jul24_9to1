package com.cts.jsf.ui;

import com.cts.jsf.services.GreetingService;

public class App12ThreadsDemo {

	public static void main(String[] args) {

		String[] friends = new String[] {"Vamsy","Murthy","Suresh","Ramesh","Krishna"};
		
		Thread t1 = new Thread(new GreetingService("Hello", friends));
		Thread t2 = new Thread(new GreetingService("Namasthey", friends));
		Thread t3 = new Thread(new GreetingService("Vanakkam", friends));
		
		//Asynchronous execution
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join(); //main will pause here until t1 is terminated
			t2.join(); //main will pause here until t2 is terminated if not already terminated 
			t3.join(); //main will pause here until t3 is terminated if not already terminated
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Synchronous execution as the main has to join t1, t2 and t3 .
		
		System.out.println("Application Terminated");
		
	}
}
