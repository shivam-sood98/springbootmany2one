package com.example.empsal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int salaryid;
	private double salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeid", referencedColumnName = "employeeId")
	private Employee employee;
	
	
	public int getSalaryid() {
		return salaryid;
	}
	public void setSalaryid(int salaryid) {
		this.salaryid = salaryid;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Salary [salaryid=" + salaryid + ", salary=" + salary + ", employee=" + employee + "]";
	}
	
	
}
