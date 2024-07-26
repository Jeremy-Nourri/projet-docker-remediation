package com.example.exercice3.service;

import com.example.exercice3.dto.absense.AbsenseDtoGet;
import com.example.exercice3.dto.absense.AbsenseDtoPost;
import com.example.exercice3.entity.Absense;
import com.example.exercice3.entity.Employee;
import com.example.exercice3.exception.NotFoundException;
import com.example.exercice3.repository.AbsenseRepository;
import com.example.exercice3.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbsenseServiceImpl implements AbsenseService {

    @Autowired
    private AbsenseRepository absenseRepository;

    @Autowired
    private EmployeeService employeeService;


    @Override
    public List<AbsenseDtoGet> getAllAbsenses() {
        return absensesToAbsenseDtoGets((List<Absense>) absenseRepository.findAll());
    }

    @Override
    public AbsenseDtoGet getAbsenseById(int id) {
       return absenseTOAbsenseDtoGet(absenseRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public void deleteAbsenseById(int id) {
        this.absenseRepository.deleteById(id);
    }

    @Override
    public AbsenseDtoGet saveAbsense(AbsenseDtoPost absenseDtoPost) {
        Absense absense = Absense.builder()
                .employee(employeeService.getById(absenseDtoPost.getEmployeeId()))
                .date(LocalDate.parse(absenseDtoPost.getDateStr(), DateFormat.DATE_FORMAT)).build();
        absenseRepository.save(absense);
        return absenseTOAbsenseDtoGet(absense);
    }

    @Override
    public List<AbsenseDtoGet> getEmployeeAbsenses(int id) {
        Employee employee = employeeService.getById(id);
        return absensesToAbsenseDtoGets(absenseRepository.findAllByEmployee(employee));
    }

    private AbsenseDtoGet absenseTOAbsenseDtoGet (Absense absense){
        return AbsenseDtoGet.builder()
                .id(absense.getId())
                .date(absense.getDate())
                .build();
    }

    private List<AbsenseDtoGet> absensesToAbsenseDtoGets(List<Absense> absenses){
        return absenses.stream().map(this::absenseTOAbsenseDtoGet).collect(Collectors.toList());
    }
}
