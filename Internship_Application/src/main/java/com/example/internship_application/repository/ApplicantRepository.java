package com.example.internship_application.repository;

import com.example.internship_application.model.entity.Applicant;
import com.example.internship_application.model.entity.Employer;
import com.example.internship_application.model.entity.JobListing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
    List<Applicant> findAllByEmployerId(Long id);
    List<Applicant> findAllByJobListingId(Long id);
}
