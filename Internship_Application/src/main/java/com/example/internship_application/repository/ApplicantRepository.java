package com.example.internship_application.repository;

import com.example.internship_application.model.entity.Applicant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
    List<Applicant> findAllByEmployerId(Long id);

    List<Applicant> findAllByJobListingId(Long id);
}
