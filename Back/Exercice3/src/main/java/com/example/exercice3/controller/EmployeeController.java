package com.example.exercice3.controller;

import com.example.exercice3.dto.employee.EmployeeDtoGet;
import com.example.exercice3.dto.employee.EmployeeDtoPost;
import com.example.exercice3.entity.Absense;
import com.example.exercice3.entity.Employee;
import com.example.exercice3.entity.Vacation;
import com.example.exercice3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDtoGet>> getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDtoGet> saveEmployee(@Validated @RequestBody() EmployeeDtoPost employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<EmployeeDtoGet> details(@PathVariable(value = "id") int id) {
      return ResponseEntity.ok(employeeService.getEmployeeById(id));

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<EmployeeDtoGet> showFormForUpdate(@PathVariable(value = "id") int id, @Validated @RequestBody() EmployeeDtoPost employee){
        return ResponseEntity.ok(employeeService.updateEmployee(id,employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int     id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee supprimé");

    }


}
