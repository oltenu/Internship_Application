package com.example.internship_application.service;

import com.example.internship_application.helpers.*;
import com.example.internship_application.model.converter.ApplicantConverter;
import com.example.internship_application.model.dto.ApplicantDto;
import com.example.internship_application.model.entity.Applicant;
import com.example.internship_application.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public void applyForAJobListing(ApplicantDto applicantDto) throws ApplicantException, EmployerException {
        if (!ApplicantValidator.validateInput(applicantDto))
            throw new ApplicantException("Invalid applicant!");

        Applicant applicant = ApplicantConverter.fromDtoToModel(applicantDto);

        applicantRepository.save(applicant);
    }

    public List<Applicant> getApplicantsByEmployer(Long id) {
        return applicantRepository.findAllByEmployerId(id);
    }

    public List<Applicant> getApplicantsByJobListing(Long id) {
        return applicantRepository.findAllByJobListingId(id);

    }

    public void deleteAll(List<Applicant> applicants) {
        applicantRepository.deleteAll(applicants);
    }
}
