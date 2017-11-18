package com.silva.socket.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Th41Future {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Start..");
		
		Callable<Integer> task = ()->{
			TimeUnit.SECONDS.sleep(2);
			return 77;
		};
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<Integer> future = executorService.submit(task);
		
		System.out.println(future.get());
		System.out.println("End.");
	}
}
