package com.cts.jsf.ui;

import com.cts.jsf.models.Bus;
import com.cts.jsf.services.ReservationService;

public class App13ThreadsDemo {

	public static void main(String[] args) {

		Bus bus = new Bus(25);
		
		ReservationService rs1 = new ReservationService(bus, 10);
		ReservationService rs2 = new ReservationService(bus, 10);
		ReservationService rs3 = new ReservationService(bus, 10);
		
		Thread t1 = new Thread(rs1);
		Thread t2 = new Thread(rs2);
		Thread t3 = new Thread(rs3);
		
		//Asynchronous execution
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("Please wait while booking seats...!");
		
		try {
			t1.join(); //main will pause here until t1 is terminated
			t2.join(); //main will pause here until t2 is terminated if not already terminated 
			t3.join(); //main will pause here until t3 is terminated if not already terminated
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("The first reserved: "+rs1.getSeatsReserved());
		System.out.println("The second reserved: "+rs2.getSeatsReserved());
		System.out.println("The third reserved: "+rs3.getSeatsReserved());
		
	}
}
