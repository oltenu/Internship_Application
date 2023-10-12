package com.example.internship_application.helpers;

import com.example.internship_application.model.dto.ApplicantDto;

public class ApplicantValidator {
    public static boolean validateInput(ApplicantDto applicantDto){
        return applicantDto.getFirstName() != null && applicantDto.getLastName() != null
                && applicantDto.getCity() != null && applicantDto.getCountry() != null
                && applicantDto.getEmail() != null && applicantDto.getPhoneNumber() != null;
    }
}
