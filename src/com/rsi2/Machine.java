package com.rsi2;

import java.util.LinkedList;

public class Machine extends Thread {
	LinkedList<Job> jobList = new LinkedList<>();
	Job job;

	public void addJob(Job job) {
		synchronized (jobList) {
			jobList.add(job);
			jobList.notifyAll();
		}
		System.out.println("addJob Chamout notify");
	}

	@Override
	public void run() {
		while (true) {
			synchronized (jobList) {
				try {
					jobList.wait();
				} catch (InterruptedException e) {}
			}
			System.out.println(jobList.size());
			job = jobList.pollFirst();
			System.out.println("machine.run - pegou da lista: jobList.pollFirst()");
			job.process();
		}
	}
}
