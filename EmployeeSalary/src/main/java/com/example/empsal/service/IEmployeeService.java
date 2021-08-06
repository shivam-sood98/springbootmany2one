package com.example.empsal.service;

import java.util.List;

import com.example.empsal.entity.Employee;
import com.example.empsal.entity.Salary;
import com.example.empsal.exception.UserNotFoundException;
import com.example.empsal.request.EmployeeDto;

public interface IEmployeeService {
	
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
	public void save(Employee employee);
	public void delete(Employee emp);
	public List<Employee> filterSalary(String type,double amt);
	EmployeeDto getDto(int id);
	public void saveSalary(Salary sal);
	EmployeeDto saveEmp(EmployeeDto empdto);
	void deleteEmpWithSal(int id);
}
