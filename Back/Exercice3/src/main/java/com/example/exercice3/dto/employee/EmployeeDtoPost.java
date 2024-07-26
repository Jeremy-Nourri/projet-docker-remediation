package com.example.exercice3.dto.employee;

import com.example.exercice3.entity.Absense;
import com.example.exercice3.entity.Vacation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDtoPost {
    private String name;
    private String identificationNumber;
    private String address;
    private String phone;
    private String email;
    private String birthDateStr;
    private String contractStartDateStr;
    private String contractEndDateStr;
    private String occupation;
    private String password;
    private boolean admin;
    private float salary;
    private String observation;
}
