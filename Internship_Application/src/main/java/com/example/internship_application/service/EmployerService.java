package com.example.internship_application.service;

import com.example.internship_application.model.converter.EmployerConverter;
import com.example.internship_application.model.dto.EmployerDto;
import com.example.internship_application.model.entity.Employer;
import com.example.internship_application.repository.EmployerRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;


    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public Employer addEmployer(EmployerDto employerDto) {
        Employer employer = EmployerConverter.fromDtoToModel(employerDto);
        return employerRepository.save(employer);
    }
}
