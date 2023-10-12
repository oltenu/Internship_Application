package com.example.internship_application.controller;

import com.example.internship_application.model.dto.EmployerDto;
import com.example.internship_application.model.entity.Applicant;
import com.example.internship_application.model.entity.Employer;
import com.example.internship_application.model.entity.JobListing;
import com.example.internship_application.service.ApplicantService;
import com.example.internship_application.service.EmployerService;
import com.example.internship_application.service.JobListingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    public EmployerService employerService;
    public JobListingService jobListingService;
    public ApplicantService applicantService;

    public EmployerController(EmployerService employerService, JobListingService jobListingService, ApplicantService applicantService){
        this.employerService = employerService;
        this.jobListingService = jobListingService;
        this.applicantService = applicantService;
    }

    @PostMapping("/add")
    public Employer addEmployer(@RequestBody EmployerDto employerDto){
        return employerService.addEmployer(employerDto);
    }

    @GetMapping("/display-applicants-by-employer={id}")
    public List<Applicant> getApplicantsByEmployer(@PathVariable Long id){
        return applicantService.getApplicantsByEmployer(id);
    }

    @GetMapping("/display-applicants-by-job-listing={id}")
    public List<Applicant> getApplicantsByJob(@PathVariable Long id){
        return applicantService.getApplicantsByJobListing(id);
    }

    @DeleteMapping("/delete-job={id}")
    public void deleteJob(@PathVariable Long id){
        jobListingService.deleteJobListing(id);
    }
}
