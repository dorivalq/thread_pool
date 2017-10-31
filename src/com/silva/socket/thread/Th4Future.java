package com.silva.socket.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Th4Future {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		Callable<Integer> task = ()->{
			TimeUnit.SECONDS.sleep(3);
			return 10;
		};
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);
		
		System.out.println("Future is done? " +future.isDone());
		
//		Integer result = future.get();
		Integer result = future.get(1,TimeUnit.SECONDS);
		
		System.out.println("Future is done? " +future.isDone());
		
		System.out.println("Result - "+result);
		
	}
}
