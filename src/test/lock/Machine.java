package test.lock;

public class Machine extends Thread {
	private Job job = new Job("job1");

	@Override
	public void run() {
		synchronized (job) {
			job.process();
			
		}
	}
}
