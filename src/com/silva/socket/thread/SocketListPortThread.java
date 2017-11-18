package com.silva.socket.thread;

import java.util.Date;

import com.silva.socket.work.ThreadListPort;

public class SocketListPortThread {
	
	public static void main(String[] args) throws Exception {
		int ini = 40000, fim = 64000;
		Long tIni = new Date().getTime();
		System.out.println("Tempo Ini: " + tIni);
		int name = 0;
		for (int i = ini; i < fim; i++) {
			ThreadListPort tlp = new ThreadListPort("127.0.0.1", i);
			Thread th = new Thread(tlp, name++ + "");
			th.start();
			// System.out.println(th.getName());
		}

		Long tFim = new Date().getTime();
		long result = tFim - tIni;
		System.out.println("Tempo: " + result);
	}
}
