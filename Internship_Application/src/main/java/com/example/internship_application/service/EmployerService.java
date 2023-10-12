package com.example.internship_application.service;

import com.example.internship_application.helpers.EmployerException;
import com.example.internship_application.helpers.JobListingException;
import com.example.internship_application.model.converter.EmployerConverter;
import com.example.internship_application.model.dto.EmployerDto;
import com.example.internship_application.model.dto.JobListingDto;
import com.example.internship_application.model.entity.Applicant;
import com.example.internship_application.model.entity.Employer;
import com.example.internship_application.model.entity.JobListing;
import com.example.internship_application.repository.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final JobListingService jobListingService;
    private final ApplicantService applicantService;


    public EmployerService(EmployerRepository employerRepository, JobListingService jobListingService, ApplicantService applicantService) {
        this.employerRepository = employerRepository;
        this.jobListingService = jobListingService;
        this.applicantService = applicantService;
    }

    public Employer addEmployer(EmployerDto employerDto){
        Employer employer = EmployerConverter.fromDtoToModel(employerDto);
        return employerRepository.save(employer);
    }
}
