package com.bappy.batch.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
Job-Launcher will call the job
 */
@RestController
public class BatchProcessController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping(path = "/fileToDb")
    public String loadFromFileToDb() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobInstanceAlreadyCompleteException, JobRestartException {

        Map<String, JobParameter> jobMap = new HashMap<>();
        jobMap.put("DevBy", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(jobMap);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("Job Status: " + jobExecution.getStatus());
        while (jobExecution.isRunning()) {
            System.out.println("Data is saving to DB.................Plz wait");
        }
        return jobExecution.getStatus().toString();
    }


}
