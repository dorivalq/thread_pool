package com.silva.socket.thread2;

import com.silva.socket.work.PortWorker;

public class ExecutorMain {
	
	public static void main(String[] args) {
		for (int i = 1000; i < 5000; i++) {
			PortWorker work = new PortWorker(i, "127.0.0.1");
//			Thread th = new Thread(new PortWorker(i, "127.0.0.1"));
			work.start();
//			th.start();
		}
	}
}
