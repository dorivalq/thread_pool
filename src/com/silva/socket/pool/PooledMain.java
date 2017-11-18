package com.silva.socket.pool;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;

public class PooledMain {
	private static String ip = "127.0.0.1";
	private static int port;

	public static void main(String[] args) throws UnknownHostException, IOException {
		ConnectionHandler hand =  new ConnectionHandler(ip, port);
		for (int i = 1000; i < 1003; i++) {
			hand.processRequest(new Socket(ip, i));
			hand.setUp(ip, i);
			new Thread(hand).start();
		}
		
	}
}

