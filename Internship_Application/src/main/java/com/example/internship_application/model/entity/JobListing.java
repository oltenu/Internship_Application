package com.example.internship_application.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "job_listing")
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "date_posted")
    private String datePosted;
    @Column(name = "application_deadline")
    private String applicationDeadline;
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
    private String description;
    @Column(name = "employment_type")
    private String employmentType;
    private String location;
}
