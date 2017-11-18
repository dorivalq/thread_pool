package com.silva.socket.thread;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadListPortPool {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String address = "127.0.0.1";

//		Callable<Integer> task = () -> {
//			int port = 1000;
//			System.out.println("Start..");
//			for (; port < 10000; port++) {
//				try (Socket soc = new Socket(address, port); OutputStream outputStream = soc.getOutputStream();) {
//					PrintWriter printWriter = new PrintWriter(outputStream);
//					System.out.println("Porta Aerta!! " + printWriter);
//
//					System.out.println("End.");
//				} catch (IOException e1) {
//					// e1.printStackTrace();
//				} finally {
//					System.out.print("." + port);
//				}
//
//			}
//			return port;
//		};
		/////////////////////////////////////////
		ExecutorService executorService = Executors.newWorkStealingPool();// newFixedThreadPool(1000);
		List<Callable<Integer>> list = new ArrayList<>();
		int i = 1000;
		for(;i<5000;i++){
			int port = i;
			list.add(()->{
				try {
					Socket soc = new Socket(address, port);
					soc.getOutputStream();
					System.out.println("!!!!!!!!!!Porta Aerta!! " + port);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("Porta: " + port);
				return port;
				
			} );
			
			List<Future<Integer>> invokeAll = executorService.invokeAll(list);
			for (Future<Integer> future : invokeAll) {
				future.get();
			}
			
		}
	}
}
