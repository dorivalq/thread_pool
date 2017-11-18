package com.rsi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Operator extends Thread {
	Shape shape = new Shape();
	Machine machine = new Machine();
	Job job;
	
	public static void main(String[] args) {
		new Operator().start();
	}
	
	@Override
	public void run() {
		System.out.println("Machine.start()******");
		machine.start();
		
		while(true){
			//pega o shape
			shape = new Shape();
			
			//pega o job do usuario
			job = pegarJobDoUduario();
			
			//machine.add job SYNC
			machine.addJob(job);
			
			System.out.println("Adicionou Job!");
		}
	}

	private Job pegarJobDoUduario() {
		String result = null;
		Job job = new Job(shape);
		try {
			sleep(500);
			System.err.println("INFORME O JOB: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			result = reader.readLine();
			System.out.println(result);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return job;
	}
}
