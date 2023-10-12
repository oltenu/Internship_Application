package com.example.internship_application.repository;

import com.example.internship_application.model.entity.JobListing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobListingRepository extends CrudRepository<JobListing, Long> {
    List<JobListing> findAllByEmployerId(Long id);
}
