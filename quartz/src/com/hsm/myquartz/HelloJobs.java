package com.hsm.myquartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJobs implements Job{
	public void execute(JobExecutionContext context)
	throws JobExecutionException {
		System.out.println("Hello Quartz! - by yiibai.com");	
		throw new JobExecutionException("Testing Exception");
	}
 
}
