package com.silva.socket.pool;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ConnectionHandler implements Runnable {
	private String ip;
	private int port;
	List<Socket> pool = new LinkedList<>();
	private Socket sock;

	public ConnectionHandler(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void setUp(String ip, int port){
		this.ip = ip;
		this.port = port;
	}
	public void handleConnection() {
		try {
			Socket soc = new Socket(ip, port);
			soc.getOutputStream();
			System.out.println("Port OK " + port);
		} catch (IOException e) {
			System.out.println("Port NOK");
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} finally {
		}
	}

	public void processRequest(Socket sock) {
		synchronized (pool) {
			pool.add(sock);
			pool.notifyAll();
		}
	}

	@Override
	public void run() {
		while (pool.isEmpty()) {
			synchronized (pool) {
				try {
					pool.wait();
				} catch (Exception e) {
					return;
				}
			}
			sock = pool.remove(0);
			System.out.println("######## REMOVEU -  SIZE: " + pool.size());
		}
		handleConnection();;
	}
}
