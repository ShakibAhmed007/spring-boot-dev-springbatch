package com.example.springbatch.samplejob;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class FirstJobExecutionListener implements JobExecutionListener {

    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Before Job " + jobExecution.getJobInstance().getJobName());
    }

    public void afterJob(JobExecution jobExecution) {
        System.out.println("After Job " + jobExecution.getJobInstance().getJobName());
    }
}
