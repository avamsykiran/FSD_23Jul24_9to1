package com.cts.jsf.services;

import java.util.ArrayList;
import java.util.List;

import com.cts.jsf.models.Bus;

public class ReservationService implements Runnable {

	private Bus bus;
	private int seatsRequired;
	private List<Integer> seatsReserved;
	
	public ReservationService(Bus bus, int seatsRequired) {
		super();
		this.bus = bus;
		this.seatsRequired = seatsRequired;
		this.seatsReserved = new ArrayList<>();
	}

	@Override
	public void run() {		
		synchronized (bus) {
			for(int i=1;i<=seatsRequired && bus.getLastAlloted()!=bus.getSeats();i++) {
				int seat = bus.getLastAlloted() +1;
				seatsReserved.add(seat);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				bus.setLastAlloted(seat);
			}	
		}
	}

	public List<Integer> getSeatsReserved() {
		return seatsReserved;
	}
}
