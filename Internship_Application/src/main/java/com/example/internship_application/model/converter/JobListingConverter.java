package com.example.internship_application.model.converter;

import com.example.internship_application.helpers.EmployerException;
import com.example.internship_application.helpers.JobListingException;
import com.example.internship_application.model.entity.JobListing;
import com.example.internship_application.model.dto.JobListingDto;
import com.example.internship_application.repository.EmployerRepository;
import org.springframework.stereotype.Component;

@Component
public class JobListingConverter {

    private static EmployerRepository employerRepository;

    public JobListingConverter(EmployerRepository employerRepository){
        this.employerRepository = employerRepository;
    }

    public static JobListingDto fromModelToDto(JobListing jobListing){
        JobListingDto jobListingDto = new JobListingDto();

        jobListingDto.setId(jobListing.getId());
        jobListingDto.setDescription(jobListing.getDescription());
        jobListingDto.setEmployerId(jobListing.getEmployer().getId());
        jobListingDto.setTitle(jobListing.getTitle());
        jobListingDto.setLocation(jobListing.getLocation());
        jobListingDto.setApplicationDeadline(jobListing.getApplicationDeadline());
        jobListingDto.setDatePosted(jobListing.getDatePosted());
        jobListingDto.setEmploymentType(jobListing.getEmploymentType());

        return jobListingDto;
    }

    public static JobListing fromDtoToModel(JobListingDto jobListingDto) throws EmployerException, JobListingException {
        JobListing jobListing = new JobListing();

        jobListing.setDescription(jobListingDto.getDescription());
        jobListing.setEmployer(employerRepository.findById(jobListingDto.getEmployerId()).orElseThrow(() -> new JobListingException("Job listing does not exist!")));
        jobListing.setLocation(jobListingDto.getLocation());
        jobListing.setTitle(jobListingDto.getTitle());
        jobListing.setApplicationDeadline(jobListingDto.getApplicationDeadline());
        jobListing.setDatePosted(jobListingDto.getDatePosted());
        jobListing.setEmploymentType(jobListingDto.getEmploymentType());

        return jobListing;
    }
}
