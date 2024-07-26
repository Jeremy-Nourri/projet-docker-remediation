package com.example.exercice3.service;



import com.example.exercice3.dto.vacation.VacationDtoGet;
import com.example.exercice3.dto.vacation.VacationDtoPost;
import com.example.exercice3.entity.Employee;
import com.example.exercice3.entity.Vacation;

import java.util.List;

public interface VacationService {
    List<VacationDtoGet> getAllVacations();

    List<VacationDtoGet> getEmployeeVacations(int id);

    VacationDtoGet saveVacation(VacationDtoPost vacation);

    VacationDtoGet getVacationById(int id);

    void deleteVacationById(int id);
}
