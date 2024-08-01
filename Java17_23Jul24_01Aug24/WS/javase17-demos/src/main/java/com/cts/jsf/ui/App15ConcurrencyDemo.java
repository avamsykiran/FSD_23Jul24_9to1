package com.cts.jsf.ui;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.cts.jsf.models.CheckPrimeResults;
import com.cts.jsf.services.CheckPrimeService;

public class App15ConcurrencyDemo {

	public static void main(String[] args) {
		
		ExecutorService exeService = Executors.newFixedThreadPool(3);
		
		try {
			List<Future<CheckPrimeResults>> results = exeService.invokeAll(Arrays.asList(
					new CheckPrimeService(25),
					new CheckPrimeService(50),
					new CheckPrimeService(105),
					new CheckPrimeService(100067),
					new CheckPrimeService(169),
					new CheckPrimeService(125)
			));
			
			for(Future<CheckPrimeResults> f : results) {
				System.out.println(f.get());
			}
			
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}
		
		exeService.shutdown();
		
		try {
			//to block the main thread until all jobs are done or for 5 secs whichever is earlier.
			exeService.awaitTermination(25,TimeUnit.SECONDS); 
			System.out.println("Application Terminated");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
