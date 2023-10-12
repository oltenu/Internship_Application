package com.example.internship_application.controller;

import com.example.internship_application.helpers.ApplicantException;
import com.example.internship_application.helpers.EmployerException;
import com.example.internship_application.helpers.JobListingException;
import com.example.internship_application.model.dto.ApplicantDto;
import com.example.internship_application.service.ApplicantService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService){
        this.applicantService = applicantService;
    }

    public void applyForAJob(@RequestBody ApplicantDto applicantDto) throws ApplicantException, JobListingException, EmployerException {
        applicantService.applyForAJobListing(applicantDto);
    }
}
