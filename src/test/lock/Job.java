package test.lock;

public class Job {
	private String jobName;

	public void process() {
		synchronized (this) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}

		}
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Job(String jobName) {
		super();
		this.jobName = jobName;
	}

}
