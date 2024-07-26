package com.example.exercice3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class Vacation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_employee")
  @JsonIgnore
  private Employee employee;

  private LocalDate end;

  private LocalDate start;
}
