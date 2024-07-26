package com.example.exercice3.dto.absense;

import com.example.exercice3.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbsenseDtoGet {
    private int id;
    private LocalDate date;
}
