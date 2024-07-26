package com.example.exercice3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String identificationNumber;

    private String address;

    private String phone;

    private String email;

    private LocalDate birthDate;

    private int rating;

    private String observation;

    private String skills;

    @Column(name = "technical_area")
    private String technicalArea;

    @Column(name = "job_interview_date")
    private LocalDate jobInterviewDate;
}
