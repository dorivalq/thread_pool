package com.silva.socket.work;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class ThreadListPort implements Runnable{
private Integer port;
private String ip; 
	public ThreadListPort(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public void run() {
		
		Socket soc;
		try {
			soc = new Socket("127.0.0.1", port);
			OutputStream outputStream = soc.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			System.out.println("porta aberta! " + port);
		} catch (Exception e){
			//System.out.print( port +" Fechada ): \n");
		}

	}

}

