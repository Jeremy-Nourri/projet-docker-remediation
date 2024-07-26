package com.example.exercice3.service;

import com.example.exercice3.dto.candidate.CandidateDtoGet;
import com.example.exercice3.dto.employee.EmployeeDtoGet;
import com.example.exercice3.dto.employee.EmployeeDtoPost;
import com.example.exercice3.entity.Candidate;
import com.example.exercice3.entity.Employee;
import com.example.exercice3.exception.NotFoundException;
import com.example.exercice3.repository.EmployeeRepository;

import com.example.exercice3.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDtoGet> getAllEmployees() {
        return employeesToEmployeeDtoGets((List<Employee>) employeeRepository.findAll());
    }

    @Override
    public EmployeeDtoGet saveEmployee(EmployeeDtoPost employeeDtoPost) {
        Employee employee = Employee.builder()
                .name(employeeDtoPost.getName())
                .identificationNumber(employeeDtoPost.getIdentificationNumber())
                .address(employeeDtoPost.getAddress())
                .phone(employeeDtoPost.getPhone())
                .email(employeeDtoPost.getEmail())
                .birthDate(LocalDate.parse(employeeDtoPost.getBirthDateStr(), DateFormat.DATE_FORMAT))
                .contractStartDate(LocalDate.parse(employeeDtoPost.getContractStartDateStr(), DateFormat.DATE_FORMAT))
                .contractEndDate(employeeDtoPost.getContractEndDateStr().isEmpty() ?null:LocalDate.parse(employeeDtoPost.getContractEndDateStr(), DateFormat.DATE_FORMAT))
                .occupation(employeeDtoPost.getOccupation())
                .password(employeeDtoPost.getPassword())
                .admin(employeeDtoPost.isAdmin())
                .salary(employeeDtoPost.getSalary())
                .observation(employeeDtoPost.getObservation())
                .build();

        employeeRepository.save(employee);
        return employeeToEmployeeDtoGet(employee);
    }

    @Override
    public EmployeeDtoGet  updateEmployee (int id , EmployeeDtoPost employeeDtoPost){
        Employee employee = employeeRepository.findById(id).orElseThrow(NotFoundException::new);
        employee.setName(employeeDtoPost.getName());
        employee.setIdentificationNumber(employeeDtoPost.getIdentificationNumber());
        employee.setAddress(employee.getAddress());
        employee.setPhone(employee.getPhone());
        employee.setEmail(employee.getEmail());
        employee.setBirthDate(LocalDate.parse(employeeDtoPost.getBirthDateStr(), DateFormat.DATE_FORMAT));
        employee.setContractStartDate(LocalDate.parse(employeeDtoPost.getContractStartDateStr(), DateFormat.DATE_FORMAT));
        employee.setContractEndDate(employeeDtoPost.getContractEndDateStr().isEmpty() ?null:LocalDate.parse(employeeDtoPost.getContractEndDateStr(), DateFormat.DATE_FORMAT));
        employee.setOccupation(employeeDtoPost.getOccupation());
        employee.setPassword(employeeDtoPost.getPassword());
        employee.setAdmin(employeeDtoPost.isAdmin());
        employee.setSalary(employeeDtoPost.getSalary());
        employee.setObservation(employeeDtoPost.getObservation());

        employeeRepository.save(employee);
        return employeeToEmployeeDtoGet(employee);
    }

    @Override
    public EmployeeDtoGet getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(NotFoundException::new);

        return employeeToEmployeeDtoGet(employee);
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow(NotFoundException::new);
    }


    @Override
    public void deleteEmployeeById(int id) {
        this.employeeRepository.deleteById(id);
    }



    private EmployeeDtoGet employeeToEmployeeDtoGet (Employee employee){
        return EmployeeDtoGet.builder()
                .id(employee.getId())
                .name(employee.getName())
                .identificationNumber(employee.getIdentificationNumber())
                .address(employee.getAddress())
                .phone(employee.getPhone())
                .email(employee.getEmail())
                .birthDate(employee.getBirthDate())
                .contractStartDate(employee.getContractStartDate())
                .contractEndDate(employee.getContractEndDate())
                .occupation(employee.getOccupation())
                .observation(employee.getObservation())
                .admin(employee.isAdmin())
                .salary(employee.getSalary())
                .build();
    }

    private List<EmployeeDtoGet> employeesToEmployeeDtoGets (List<Employee> employees){
        return employees.stream().map(this::employeeToEmployeeDtoGet).collect(Collectors.toList());
    }

}
