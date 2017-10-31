package com.silva.socket.thread;

import java.util.concurrent.TimeUnit;

public class Th1 {
	public static void main(String[] args) {
		Runnable task = () -> {
			String tName = Thread.currentThread().getName();
			System.out.println(tName);
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Fim: "+tName);
			
		};
		task.run();
		Thread th2 = new Thread(task);
		th2.start();
		
		System.out.println("Done!!");
	}
}
