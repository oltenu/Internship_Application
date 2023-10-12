package com.example.internship_application.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
}
