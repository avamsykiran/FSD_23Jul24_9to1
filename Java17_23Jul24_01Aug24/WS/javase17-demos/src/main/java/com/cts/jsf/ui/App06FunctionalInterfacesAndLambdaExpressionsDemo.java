package com.cts.jsf.ui;

import java.time.LocalTime;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class App06FunctionalInterfacesAndLambdaExpressionsDemo {

	public static void main(String[] args) {
		
		Consumer<Object> csm = System.out::println;

		Supplier<String> greeting = () -> "Hello! How are you!?";
		
		//System.out.println(greeting.get());
		csm.accept(greeting.get());
		
		Supplier<String> greetingBasedOnTime = () -> {
			
			String greet="";
			
			int h = LocalTime.now().getHour();
			
			if(h>=3 && h<=11) greet = "Good Morning";
			else if(h>11 && h<=16) greet = "Good Noon";
			else greet= "Good Evening";
			
			return greet;
		};
		
		//System.out.println(greetingBasedOnTime.get());
		csm.accept(greetingBasedOnTime.get());
		
		
	}

}
