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
public class AbsenseDtoPost {
    private int employeeId;
    private String dateStr;
}
