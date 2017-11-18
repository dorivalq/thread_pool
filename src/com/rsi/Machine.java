package com.rsi;

import java.util.LinkedList;
import java.util.List;

public class Machine extends Thread {
	List<Job> jobList = new LinkedList<>();

	public void addJob(Job job) {
		synchronized (jobList) {
			jobList.add(job);
			jobList.notifyAll();
			System.out.println("Chamou notifyAll");
		}
	}

	Job job;

	@Override
	public void run() {
		while(true){
		System.out.println("machine.run() entrou..");
		while (jobList.isEmpty()) {
			synchronized (jobList) {
				try {
					System.out.println("Chamando wait..");
					jobList.wait();
				} catch (InterruptedException e) {
				}
			}
			System.out.println("Executou run() - jobList.remove(0)");
			job = jobList.remove(0);
		}
		String str = job.execute();
		System.out.println("machine.run - executou job.execute()" + str);
	 }
	}
}
