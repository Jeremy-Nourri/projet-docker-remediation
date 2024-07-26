package com.example.exercice3.controller;


import com.example.exercice3.dto.absense.AbsenseDtoGet;
import com.example.exercice3.dto.absense.AbsenseDtoPost;
import com.example.exercice3.dto.vacation.VacationDtoGet;
import com.example.exercice3.entity.Absense;
import com.example.exercice3.entity.Employee;
import com.example.exercice3.service.AbsenseService;
import com.example.exercice3.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/absenses")
public class AbsenseController {

    @Autowired
    private AbsenseService absenseService;

    @GetMapping("/all")
    public ResponseEntity<List<AbsenseDtoGet>> getAll() {
        return ResponseEntity.ok(absenseService.getAllAbsenses());
    }


    @PostMapping("/save")
    public ResponseEntity<AbsenseDtoGet> saveAbsense(@RequestBody AbsenseDtoPost absense) {
        return ResponseEntity.status(HttpStatus.CREATED).body(absenseService.saveAbsense(absense));
    }

     @GetMapping("/details/{id}")
     public ResponseEntity<AbsenseDtoGet> details(@PathVariable("id") int id) {
        return ResponseEntity.ok(absenseService.getAbsenseById(id));
     }


     @GetMapping("/delete/{id}")
     public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        absenseService.deleteAbsenseById(id);
        return ResponseEntity.ok("Absense delete");
     }
    @GetMapping("/employee/{id}")
    public ResponseEntity<List<AbsenseDtoGet>> getByIdEmployee (@PathVariable("id") int id){
        return ResponseEntity.ok(absenseService.getEmployeeAbsenses(id));
    }

}
