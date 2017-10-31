package com.silva.socket.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Th5InvokeAll {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService pool = Executors.newWorkStealingPool();
		List<Callable<String>> callales = Arrays.asList(
				()->"Task1",
				()->"Task2",
				()->"Task3"
				);
		List<Future<String>> futures = pool.invokeAll(callales);	
		futures.stream().map(future ->{
			try {
				return future.get();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).forEach(System.out::println);
	}
}
