package com.silva.socket.thread;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketListPort {
	public static void main(String[] args) throws Exception, IOException {
		int ini = 44000;
		int fim = 44030;
		for (int i = ini; i < fim; i++) {
			Socket soc = null;
			try {
				System.out.print("Verificnao porta..." +i);
				 soc =  new Socket("127.0.0.1",i);
				 OutputStream outputStream = soc.getOutputStream();
				 PrintWriter printWriter = new PrintWriter(outputStream);
				 System.out.println(" - Porta Aberta: " + i);
			} catch (Exception e) {
				System.out.print(" - NOK.\n");
			}
		}
	}
}
