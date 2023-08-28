package com.example.springbatch.samplejob;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SampleJob {

    @Autowired
    private FirstTasklet firstTasklet;

    @Autowired
    private FirstJobExecutionListener firstJobExecutionListener;

    @Bean(name = "firstjob")
    public Job firstJob(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        System.out.println("First Job Executed !!!");
        return new JobBuilder("firstjob", jobRepository)
                .start(firstStep(jobRepository, transactionManager))
                .listener(firstJobExecutionListener)
                .build();
    }

    public Step firstStep(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        System.out.println("First Step Builder Executed !!!");
        return new StepBuilder("first step", jobRepository)
                .tasklet(firstTasklet, transactionManager)
                .build();
    }
}
