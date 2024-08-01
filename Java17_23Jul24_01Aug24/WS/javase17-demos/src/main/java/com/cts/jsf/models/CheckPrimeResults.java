package com.cts.jsf.models;

import java.util.List;

public class CheckPrimeResults {

	private int num;
	private List<Integer> factors;
	private boolean isPrime;
	
	public CheckPrimeResults(int num, List<Integer> factors, boolean isPrime) {
		super();
		this.num = num;
		this.factors = factors;
		this.isPrime = isPrime;
	}

	@Override
	public String toString() {
		return "CheckPrimeResults [num=" + num + ", factors=" + factors + ", isPrime=" + isPrime + "]";
	}
	
	
}
