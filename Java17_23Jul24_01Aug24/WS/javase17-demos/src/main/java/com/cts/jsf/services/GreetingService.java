package com.cts.jsf.services;

public class GreetingService implements Runnable {

	private String greeting;
	private String[] userNames;
	
	public GreetingService(String greeting,String[] userNames) {
		this.greeting=greeting;
		this.userNames=userNames;
	}
	
	@Override
	public void run() {
		for(String unm : userNames) {
			System.out.printf("%s %s\n",greeting,unm);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
