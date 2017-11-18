package com.rsi2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Operator extends Thread {
	static Machine machine = new Machine();
	static LinkedList<Runnable> pool = new LinkedList<>();
	
	public static void main(String[] args) {
		machine.start();
		
		while(true){
			// recupera jo do usuario
			Job job = retieveJob();
	
			// add job
			System.out.println("Operador - chamou add job()");
			machine.addJob(job);
		}
	}

	private static Job retieveJob() {
		try {
			//new BufferedReader(new InputStreamReader(System.in)).readLine();
			System.out.println("---1--Leu entrada..");
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Job();
	}

}
