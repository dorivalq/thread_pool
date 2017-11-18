package com.silva.socket.work;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortWorker extends Thread {
	private int port;
	private String ip;

	public PortWorker(int port, String ip) {
		this.port = port;
		this.ip = ip;
	}

	@Override
	public void run() {
		System.out.println("Starting " + this.getName()+ " Port: "+port);
		try {
//			listPort();//
			Socket soc = new Socket(ip, port);
			soc.getOutputStream();
			System.out.println("%%%%%%%%%%%%%%%%Open port: " + port);
			
		} catch (UnknownHostException e) {
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}
}
