package com.example.exercice3.controller;

import com.example.exercice3.dto.vacation.VacationDtoGet;
import com.example.exercice3.dto.vacation.VacationDtoPost;
import com.example.exercice3.entity.Employee;
import com.example.exercice3.entity.Vacation;
import com.example.exercice3.service.EmployeeService;
import com.example.exercice3.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/vacations")
public class VacationController {

    @Autowired
    private VacationService vacationService;
    ;

    @GetMapping("/all")
    public ResponseEntity<List<VacationDtoGet>> getAll() {
        return ResponseEntity.ok(vacationService.getAllVacations());
    }

    @PostMapping("/save")
    public ResponseEntity<VacationDtoGet> saveVacation(@RequestBody VacationDtoPost vacation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vacationService.saveVacation(vacation));
    }

     @GetMapping("/details/{id}")
     public ResponseEntity<VacationDtoGet> details(@PathVariable("id") int id) {
     return ResponseEntity.ok(vacationService.getVacationById(id));
     }


     @DeleteMapping("/delete/{id}")
     public ResponseEntity<String> deleteVacation(@PathVariable("id") int id) {
     this.vacationService.deleteVacationById(id);
     return ResponseEntity.ok("vacation delete");
     }

     @GetMapping("/employee/{id}")
    public ResponseEntity<List<VacationDtoGet>> getByIdEmployee (@PathVariable("id") int id){
        return ResponseEntity.ok(vacationService.getEmployeeVacations(id));
     }
}
