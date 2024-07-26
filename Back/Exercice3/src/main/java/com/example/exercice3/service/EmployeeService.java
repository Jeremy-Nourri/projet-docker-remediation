package com.example.exercice3.service;

import com.example.exercice3.dto.employee.EmployeeDtoGet;
import com.example.exercice3.dto.employee.EmployeeDtoPost;
import com.example.exercice3.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;


public interface EmployeeService {
    List<EmployeeDtoGet> getAllEmployees();
    EmployeeDtoGet saveEmployee(EmployeeDtoPost employee);
    EmployeeDtoGet getEmployeeById(int id);
    Employee getById(int id);
    EmployeeDtoGet updateEmployee (int id , EmployeeDtoPost employeeDtoPost);
    void deleteEmployeeById(int id);
}
