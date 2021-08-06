package com.example.empsal.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.empsal.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
