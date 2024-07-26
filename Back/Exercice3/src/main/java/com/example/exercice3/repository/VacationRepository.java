package com.example.exercice3.repository;

import com.example.exercice3.entity.Employee;
import com.example.exercice3.entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends CrudRepository<Vacation, Integer> {

  List<Vacation> findAllByEmployee(Employee employee);

}
