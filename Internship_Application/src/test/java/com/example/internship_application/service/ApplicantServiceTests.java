package com.example.internship_application.service;

import com.example.internship_application.helpers.ApplicantValidator;
import com.example.internship_application.model.dto.ApplicantDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicantServiceTests {
    private static ApplicantDto trueApplicantDto;
    private static ApplicantDto falseApplicantDto;

    @BeforeAll
    public static void setUp() {
        trueApplicantDto = new ApplicantDto();
        trueApplicantDto.setEmployerId(1L);
        trueApplicantDto.setPhoneNumber("0712345678");
        trueApplicantDto.setCity("Cluj-Napoca");
        trueApplicantDto.setCountry("Romania");
        trueApplicantDto.setId(1L);
        trueApplicantDto.setJobListingId(1L);
        trueApplicantDto.setEmail("applicant@dom.com");
        trueApplicantDto.setLastName("Popescu");
        trueApplicantDto.setFirstName("Gheorghe");
        trueApplicantDto.setAddressLine1("Horea, nr 88");


        falseApplicantDto = new ApplicantDto();
        falseApplicantDto.setEmployerId(1L);
        falseApplicantDto.setCity("Cluj-Napoca");
        falseApplicantDto.setCountry("Romania");
        falseApplicantDto.setId(1L);
        falseApplicantDto.setJobListingId(1L);
        falseApplicantDto.setEmail("applicant@dom.com");
        falseApplicantDto.setLastName("Popescu");
        falseApplicantDto.setFirstName("Gheorghe");
        falseApplicantDto.setAddressLine1("Horea, nr 88");
    }


    @Test
    public void TestTrue() {
        assertTrue(ApplicantValidator.validateInput(trueApplicantDto));
    }

    @Test
    public void TestFalse() {
        assertFalse(ApplicantValidator.validateInput(falseApplicantDto));
    }
}
