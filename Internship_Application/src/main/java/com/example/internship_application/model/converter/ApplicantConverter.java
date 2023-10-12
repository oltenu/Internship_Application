package com.example.internship_application.model.converter;

import com.example.internship_application.helpers.ApplicantException;
import com.example.internship_application.helpers.EmployerException;
import com.example.internship_application.helpers.JobListingException;
import com.example.internship_application.model.entity.Applicant;
import com.example.internship_application.model.dto.ApplicantDto;
import com.example.internship_application.repository.EmployerRepository;
import com.example.internship_application.repository.JobListingRepository;
import com.example.internship_application.service.JobListingService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicantConverter {
    private static JobListingRepository jobListingRepository;
    private static EmployerRepository employerRepository;

    public ApplicantConverter(JobListingRepository jobListingRepository, EmployerRepository employerRepository){
        this.jobListingRepository = jobListingRepository;
        this.employerRepository = employerRepository;
    }

    public static ApplicantDto fromModelToDto(Applicant applicant){
        ApplicantDto applicantDto = new ApplicantDto();

        applicantDto.setId(applicant.getId());
        applicantDto.setCity(applicant.getCity());
        applicantDto.setEmail(applicant.getEmail());
        applicantDto.setCountry(applicant.getCountry());
        applicantDto.setState(applicant.getState());
        applicantDto.setAddressLine1(applicant.getAddressLine1());
        applicantDto.setFirstName(applicant.getFirstName());
        applicantDto.setLastName(applicant.getLastName());
        applicantDto.setPhoneNumber(applicant.getPhoneNumber());
        applicantDto.setAddressLine2(applicant.getAddressLine2());
        applicantDto.setJobListingId(applicant.getJobListing().getId());
        applicantDto.setEmployerId(applicant.getEmployer().getId());

        return applicantDto;
    }

    public static Applicant fromDtoToModel(ApplicantDto applicantDto) throws JobListingException, ApplicantException, EmployerException {
        Applicant applicant = new Applicant();

        applicant.setAddressLine1(applicantDto.getAddressLine1());
        applicant.setCity(applicantDto.getCity());
        applicant.setEmail(applicantDto.getEmail());
        applicant.setCountry(applicantDto.getCountry());
        applicant.setId(applicantDto.getId());
        applicant.setState(applicantDto.getState());
        applicant.setPhoneNumber(applicantDto.getPhoneNumber());
        applicant.setLastName(applicantDto.getLastName());
        applicant.setFirstName(applicantDto.getFirstName());
        applicant.setAddressLine2(applicantDto.getAddressLine2());
        applicant.setJobListing(jobListingRepository.findById(applicantDto.getJobListingId()).orElseThrow(()
                -> new ApplicantException("No job listing found!")));
        applicant.setEmployer(employerRepository.findById(applicantDto.getEmployerId()).orElseThrow(()
                -> new EmployerException("No employer found!")));

        return applicant;
    }
}
