package com.example.internship_application.repository;

import com.example.internship_application.model.entity.Employer;
import org.springframework.data.repository.CrudRepository;

public interface EmployerRepository extends CrudRepository<Employer, Long> {
}
