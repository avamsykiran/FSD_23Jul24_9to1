package com.cts.jsf.ui;

public class App11ThreadsDemo {

	public static void main(String[] args) {

		Thread thread = Thread.currentThread();
		
		System.out.println(thread.getName());
	}
}
