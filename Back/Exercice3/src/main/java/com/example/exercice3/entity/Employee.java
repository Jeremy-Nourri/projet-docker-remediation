package com.example.exercice3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
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

    private String password;

    private boolean admin;

    private Float salary;

    private String observation;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vacation> vacations;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Absense> absenses;

}
