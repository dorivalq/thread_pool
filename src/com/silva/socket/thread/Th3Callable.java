package com.silva.socket.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Th3Callable {
	public static void main(String[] args) {
		Callable<Integer> task = ()->{
			TimeUnit.SECONDS.sleep(2);
			return 99;
		};		
		try {
			Integer call = task.call();
			System.out.println(call);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
