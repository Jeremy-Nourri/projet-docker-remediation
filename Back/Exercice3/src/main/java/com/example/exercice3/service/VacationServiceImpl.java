package com.example.exercice3.service;

import com.example.exercice3.dto.absense.AbsenseDtoGet;
import com.example.exercice3.dto.vacation.VacationDtoGet;
import com.example.exercice3.dto.vacation.VacationDtoPost;
import com.example.exercice3.entity.Absense;
import com.example.exercice3.entity.Employee;
import com.example.exercice3.entity.Vacation;
import com.example.exercice3.exception.NotFoundException;
import com.example.exercice3.repository.VacationRepository;
import com.example.exercice3.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VacationServiceImpl implements VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<VacationDtoGet> getAllVacations() {
        return vacationsToVactionDtoGets((List<Vacation>) vacationRepository.findAll());
    }

    @Override
    public VacationDtoGet getVacationById(int id) {
        return vacationToVacationDtoGet(vacationRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public void deleteVacationById(int id) {
        this.vacationRepository.deleteById(id);
    }

    @Override
    public VacationDtoGet saveVacation(VacationDtoPost vacationDtoPost) {
        Vacation vacation = Vacation.builder()
                .employee(employeeService.getById(vacationDtoPost.getEmployeeId()))
                .start(LocalDate.parse(vacationDtoPost.getStartStr(), DateFormat.DATE_FORMAT))
                .end(LocalDate.parse(vacationDtoPost.getEndStr(), DateFormat.DATE_FORMAT)).build();
        vacationRepository.save(vacation);
        return vacationToVacationDtoGet(vacation);
    }

    @Override
    public List<VacationDtoGet> getEmployeeVacations(int id) {
        Employee employee = employeeService.getById(id);
        return vacationsToVactionDtoGets(vacationRepository.findAllByEmployee(employee));
    }


    private VacationDtoGet vacationToVacationDtoGet (Vacation vacation){
        return VacationDtoGet.builder()
                .id(vacation.getId())
                .start(vacation.getStart())
                .end(vacation.getEnd())
                .build();
    }

    private List<VacationDtoGet> vacationsToVactionDtoGets(List<Vacation> vacations){
        return vacations.stream().map(this::vacationToVacationDtoGet).collect(Collectors.toList());
    }
}
