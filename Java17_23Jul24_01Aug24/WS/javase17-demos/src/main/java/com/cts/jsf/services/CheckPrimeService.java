package com.cts.jsf.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.cts.jsf.models.CheckPrimeResults;

public class CheckPrimeService implements Callable<CheckPrimeResults> {

	private int num;
	
	public CheckPrimeService(int num) {
		this.num=num;
	}
	
	@Override
	public CheckPrimeResults call() throws Exception {
		
		List<Integer> factors = new ArrayList<>();
		
		factors.add(1);
		
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) {
				factors.add(i);
			}
		}
		
		factors.add(num);
		return new CheckPrimeResults(num, factors, factors.size()==2);
	}

}
