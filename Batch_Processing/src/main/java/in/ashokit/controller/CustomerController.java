package in.ashokit.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	
	@GetMapping("/customers")
	public void loadCSVTODB() throws Exception {
		JobParameters jobParams = new JobParametersBuilder().addLong("Strat-At", System.currentTimeMillis())
				.toJobParameters();
		
		jobLauncher.run(job, jobParams);
	}

}
