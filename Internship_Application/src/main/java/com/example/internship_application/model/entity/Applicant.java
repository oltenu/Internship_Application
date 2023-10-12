package com.example.internship_application.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name = "address_line_2")
    private String addressLine2;
    private String country;
    private String state;
    private String city;
    @OneToOne
    @JoinColumn(name="job_listing_id")
    private JobListing jobListing;
    @OneToOne
    @JoinColumn(name="employer_id")
    private Employer employer;
}
