package com.example.exercice3.repository;

import com.example.exercice3.entity.Absense;
import com.example.exercice3.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenseRepository extends CrudRepository<Absense, Integer> {

  List<Absense> findAllByEmployee(Employee employee);

}
