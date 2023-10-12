package com.example.internship_application.model.dto;

import com.example.internship_application.model.entity.Employer;
import lombok.Data;

@Data
public class JobListingDto {
    private Long id;
    private String title;
    private String datePosted;
    private String applicationDeadline;
    private Long employerId;
    private String description;
    private String employmentType;
    private String location;
}
