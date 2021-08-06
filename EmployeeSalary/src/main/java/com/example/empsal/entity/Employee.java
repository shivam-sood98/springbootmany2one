package com.example.empsal.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int employeeId;
	
	@NotNull
	@Size(min=3, max=30)
	private String empName;
	
	@NotNull
    @Min(18)
	private int employeeAge;
	
	@OneToOne(mappedBy = "employee")
	private Salary salary;
	
	@Enumerated(EnumType.STRING)
	private Gender employeeGender;

	public Employee()
	{
		
	}
	public Employee(int employeeId, String empName) {
		super();
		this.employeeId = employeeId;
		this.empName = empName;
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

	

	public Gender getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(Gender employeeGender) {
		this.employeeGender = employeeGender;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empName=" + empName + ", employeeAge=" + employeeAge
				+ ", employeeGender=" + employeeGender + "]";
	}
	
	
}
