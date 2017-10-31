package com.silva.socket.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Th2 {
	public static void main(String[] args) {
		ExecutorService pool =  Executors.newSingleThreadExecutor();
		pool.submit(() ->{
			System.out.println(Thread.currentThread().getName());
		});
		pool.shutdown();
	}
}
