package com.example.internship_application.controller;

import com.example.internship_application.helpers.EmployerException;
import com.example.internship_application.helpers.JobListingException;
import com.example.internship_application.model.dto.JobListingDto;
import com.example.internship_application.model.entity.JobListing;
import com.example.internship_application.service.JobListingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobListingController {
    private final JobListingService jobListingService;

    public JobListingController(JobListingService jobListingService){
            this.jobListingService = jobListingService;
    }

    @GetMapping("/{id}")
    public List<JobListing> displayJobListingsByEmployer(@PathVariable Long id){
        return jobListingService.getJobListingsByEmployer(id);
    }

    @PostMapping("/add")
    public JobListing addJobListing(@RequestBody JobListingDto jobListingDto) throws JobListingException, EmployerException {
        return jobListingService.addJobListing(jobListingDto);
    }
}
