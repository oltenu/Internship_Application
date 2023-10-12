package com.example.internship_application.model.dto;

import lombok.Data;

@Data
public class ApplicantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String state;
    private String city;
    private Long jobListingId;
    private Long employerId;
}
