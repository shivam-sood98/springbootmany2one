package com.example.empsal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.empsal.entity.Salary;

public interface SalaryRepository extends CrudRepository<Salary, Integer>{
	
    Salary findByEmployee_employeeId(int i);
	
    List<Salary> findBySalaryGreaterThan(double amount);
	
	List<Salary> findBySalaryLessThan(double amount);
	
}
