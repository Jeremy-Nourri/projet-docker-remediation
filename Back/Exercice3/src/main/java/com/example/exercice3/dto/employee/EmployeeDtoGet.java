package com.example.exercice3.dto.employee;

import com.example.exercice3.entity.Absense;
import com.example.exercice3.entity.Vacation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDtoGet {
    private int id;
    private String name;
    private String identificationNumber;
    private String address;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private String occupation;
    private boolean admin;
    private float salary;
    private String observation;
    private List<Vacation> vacations;
    private List<Absense> absenses;
}
