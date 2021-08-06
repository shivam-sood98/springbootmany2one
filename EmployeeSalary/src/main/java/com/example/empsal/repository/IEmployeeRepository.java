package com.example.empsal.repository;

import java.util.List;

import com.example.empsal.entity.Employee;
import com.example.empsal.entity.Salary;

public interface IEmployeeRepository {
	public Employee findById(int id);
	public List<Employee> getAllemp();
	public void save(Employee employee);
	public void delete(Employee employee);
	Salary getSalaryFromEmpId(int id);
	List<Salary> greaterThan(double amount);
	List<Salary> lessThan(double amount);
}
