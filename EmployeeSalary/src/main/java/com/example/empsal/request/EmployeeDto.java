package com.example.empsal.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.empsal.entity.Gender;

public class EmployeeDto {

	private int employeeId;
	private String empName;
	private int employeeAge;
	private double salary;
	
	@Enumerated(EnumType.STRING)
	private Gender employeeGender;
	
	public Gender getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(Gender employeeGender) {
		this.employeeGender = employeeGender;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
