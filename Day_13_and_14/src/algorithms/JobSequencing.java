package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSequencing {

	public static List<Job> scheduleJobs(List<Job> jobs) {
			Collections.sort(jobs, (job1, job2) -> job2.Profit - job1.Profit); // 
//Sort by decreasing profit
		
			List<Job> scheduledJobs = new ArrayList<>();
			int[] deadlines = new int[jobs.size() + 1];
		
			for (Job job : jobs) {
					// Find the latest slot available before deadline
					int slot = job.Deadline;
					while (slot > 0 && deadlines[slot] > 0) {
							slot--;
					}
		
					if (slot > 0) {
							deadlines[slot] = job.Id;
							scheduledJobs.add(job);
					}
			}
		
			return scheduledJobs;
	}
		
	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1, 2, 50));
		jobs.add(new Job(2, 1, 100));
		jobs.add(new Job(3, 2, 30));
		jobs.add(new Job(4, 1, 20));
	
		List<Job> scheduledJobs = scheduleJobs(jobs);
		System.out.println("Scheduled Jobs: ");
		for (Job job : scheduledJobs) {
				System.out.println("Job Id: " + job.Id + ", Profit: " +
job.Profit);
		}
	}
}
