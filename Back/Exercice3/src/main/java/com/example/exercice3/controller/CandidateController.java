package com.example.exercice3.controller;

import com.example.exercice3.dto.candidate.CandidateDtoGet;
import com.example.exercice3.dto.candidate.CandidateDtoPost;
import com.example.exercice3.dto.employee.EmployeeDtoGet;
import com.example.exercice3.entity.Absense;
import com.example.exercice3.entity.Candidate;
import com.example.exercice3.entity.Vacation;
import com.example.exercice3.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/candidates")
@CrossOrigin
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/all")
    public ResponseEntity<List<CandidateDtoGet>> getAll() {
       return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    @PostMapping("/save")
    public String saveCandidate(@Validated @RequestBody() CandidateDtoPost candidate) {

        candidateService.saveCandidate(candidate);
        return "redirect:/candidates/all";
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<CandidateDtoGet> details(@PathVariable(value = "id") int id, Model model) {
        return ResponseEntity.ok(candidateService.getCandidateById(id))  ;
    }


    @DeleteMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable(value = "id") int id) {
        this.candidateService.deleteCandidateById(id);
        return "redirect:/candidates/all";
    }

}
