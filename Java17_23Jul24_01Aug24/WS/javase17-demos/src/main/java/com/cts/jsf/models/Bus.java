package com.cts.jsf.models;

public class Bus {

	private int seats;
	private int lastAlloted;
	
	public Bus(int seats) {
		super();
		this.seats = seats;
		this.lastAlloted = 0;
	}

	public int getLastAlloted() {
		return lastAlloted;
	}

	public void setLastAlloted(int lastAlloted) {
		this.lastAlloted = lastAlloted;
	}

	public int getSeats() {
		return seats;
	}
	
	
}
