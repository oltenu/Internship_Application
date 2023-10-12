package com.example.internship_application.service;

import com.example.internship_application.helpers.EmployerException;
import com.example.internship_application.helpers.JobListingException;
import com.example.internship_application.model.converter.JobListingConverter;
import com.example.internship_application.model.dto.JobListingDto;
import com.example.internship_application.model.entity.Applicant;
import com.example.internship_application.model.entity.JobListing;
import com.example.internship_application.repository.JobListingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobListingService {
    private final JobListingRepository jobListingRepository;
    private final ApplicantService applicantService;

    public JobListingService(JobListingRepository jobListingRepository, ApplicantService applicantService) {
        this.jobListingRepository = jobListingRepository;
        this.applicantService = applicantService;
    }

    public JobListing addJobListing(JobListingDto jobListingDto) throws JobListingException, EmployerException {
        if (jobListingDto.getTitle() == null) {
            throw new JobListingException("A job listing should have a title!");
        } else if (jobListingDto.getEmploymentType() == null) {
            throw new JobListingException("Select an employment type!");
        }

        JobListing jobListing = JobListingConverter.fromDtoToModel(jobListingDto);

        jobListingRepository.save(jobListing);

        return jobListing;
    }

    public JobListing getJobListing(Long id) throws JobListingException {
        return jobListingRepository.findById(id).orElseThrow(() -> new JobListingException("No job listing found!"));
    }

    public List<JobListing> getJobListingsByEmployer(Long id) {
        return jobListingRepository.findAllByEmployerId(id);
    }

    public void deleteJobListing(Long id) {
        jobListingRepository.deleteById(id);
    }
}
