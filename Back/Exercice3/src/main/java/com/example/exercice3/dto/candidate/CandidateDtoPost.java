package com.example.exercice3.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateDtoPost {
    private String name;
    private String identificationNumber;
    private String address;
    private String phone;
    private String email;
    private String birthDateStr;
    private int rating;
    private String observation;
    private String skills;
    private String technicalArea;
    private String jobInterviewDateStr;
}
