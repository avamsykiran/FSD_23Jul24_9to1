package com.cts.jsf.ui;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.cts.jsf.services.GreetingService;

public class App14ConcurrencyDemo {

	public static void main(String[] args) {
		
		String[] friends = new String[] {"Vamsy","Murthy","Suresh","Ramesh","Krishna"};
		
		GreetingService gs1 = new GreetingService("Hello",friends);
		GreetingService gs2 = new GreetingService("Namasthey",friends);
		GreetingService gs3 = new GreetingService("Vanakkam",friends);
		
		//ExecutorService exeService = Executors.newSingleThreadExecutor();
		ExecutorService exeService = Executors.newFixedThreadPool(2);
		
		exeService.execute(gs1);
		exeService.execute(gs2);
		exeService.execute(gs3);
		
		exeService.shutdown();
		
		try {
			//to block the main thread until all jobs are done or for 5 secs whichever is earlier.
			exeService.awaitTermination(5,TimeUnit.SECONDS); 
			System.out.println("Application Terminated");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
