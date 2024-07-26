package com.example.exercice3.dto.vacation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacationDtoPost {
    private int employeeId;
    private String startStr;
    private String endStr;
}
