package com.example.internship_application.model.converter;

import com.example.internship_application.model.entity.Employer;
import com.example.internship_application.model.dto.EmployerDto;
import org.springframework.stereotype.Component;

@Component
public class EmployerConverter {
    public static EmployerDto fromModelToDto(Employer employer){
        EmployerDto employerDto = new EmployerDto();

        employerDto.setPhoneNumber(employer.getPhoneNumber());
        employerDto.setId(employer.getId());
        employerDto.setEmail(employer.getEmail());
        employerDto.setName(employer.getName());
        employerDto.setAddress(employer.getAddress());

        return employerDto;
    }

    public static Employer fromDtoToModel(EmployerDto employerDto){
        Employer employer = new Employer();

        employer.setAddress(employerDto.getAddress());
        employer.setEmail(employerDto.getEmail());
        employer.setPhoneNumber(employerDto.getPhoneNumber());
        employer.setName(employerDto.getName());

        return employer;
    }
}
