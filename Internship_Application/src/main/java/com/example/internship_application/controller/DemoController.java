package com.example.internship_application.controller;

import com.example.internship_application.helpers.ApplicantException;
import com.example.internship_application.helpers.EmployerException;
import com.example.internship_application.helpers.JobListingException;
import com.example.internship_application.model.entity.Applicant;
import com.example.internship_application.model.entity.Employer;
import com.example.internship_application.model.entity.JobListing;
import com.example.internship_application.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/init")
    public String init() throws ApplicantException, JobListingException, EmployerException {
        demoService.init();

        return "DONE";
    }

    @GetMapping("/jobs-by-employer")
    public List<JobListing> displayJobsByEmployer() {
        return demoService.displayJobsByEmployer();
    }

    @GetMapping("/applicants-by-employer")
    public List<Applicant> displayApplicantsByEmployer() {
        return demoService.displayApplicantsByEmployer();
    }

    @GetMapping("/applicants-by-job")
    public List<Applicant> displayApplicantsByJob() {
        return demoService.displayApplicantsByJob();
    }

    @GetMapping("/delete-a-job")
    public List<JobListing> deleteAJob() {
        demoService.deleteAJob();

        return demoService.displayJobs();
    }

    @GetMapping("/display-jobs")
    public List<JobListing> displayJobs() {
        return demoService.displayJobs();
    }

    @GetMapping("/display-employers")
    public List<Employer> displayEmployers() {
        return demoService.displayEmployers();
    }

    @GetMapping("/display-applicants")
    public List<Applicant> displayApplicants() {
        return demoService.displayApplicants();
    }
}
