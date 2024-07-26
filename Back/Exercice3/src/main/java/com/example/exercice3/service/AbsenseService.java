package com.example.exercice3.service;



import com.example.exercice3.dto.absense.AbsenseDtoGet;
import com.example.exercice3.dto.absense.AbsenseDtoPost;
import com.example.exercice3.entity.Absense;
import com.example.exercice3.entity.Employee;

import java.util.List;

public interface AbsenseService{
    List<AbsenseDtoGet> getAllAbsenses();

    List<AbsenseDtoGet> getEmployeeAbsenses(int id);

    AbsenseDtoGet saveAbsense(AbsenseDtoPost absenseDtoPost);

    AbsenseDtoGet getAbsenseById(int id);

    void deleteAbsenseById(int id);
}
