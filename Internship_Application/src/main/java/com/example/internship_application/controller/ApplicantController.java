package com.example.internship_application.controller;

import com.example.internship_application.helpers.*;
import com.example.internship_application.model.dto.ApplicantDto;
import com.example.internship_application.service.ApplicantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping("/apply")
    public void applyForAJob(@RequestBody ApplicantDto applicantDto) throws ApplicantException, EmployerException {
        applicantService.applyForAJobListing(applicantDto);
    }
}
