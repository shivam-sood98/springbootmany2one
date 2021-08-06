package com.example.empsal.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.empsal.entity.Employee;
import com.example.empsal.entity.Salary;
import com.example.empsal.exception.UserNotFoundException;

import javassist.NotFoundException;

public class EmployeeRepositoryImpl implements IEmployeeRepository{

	@Autowired
	private EmployeeRepository dao;
	
	@Autowired
	private SalaryRepository sdao;
	
	@Override
	public Employee findById(int id) 
	{
		Employee emp=dao.findById(id).get();
		
		return emp;
	}

	@Override
	public void save(Employee employee) {
		
		dao.save(employee);
	}

	@Override
	public List<Employee> getAllemp() {
		// TODO Auto-generated method stub
		return (List<Employee>) dao.findAll();
	}

	@Override
	public void delete(Employee emp) {
		dao.delete(emp);
	}
	
	@Override
	public Salary getSalaryFromEmpId(int id)
	{
		Salary sal=sdao.findByEmployee_employeeId(id);
		if(sal==null)
			throw new RuntimeException("NO EMPLOYEE FOUND");
		return sdao.findByEmployee_employeeId(id);
	}
//List<Salary> findBySalaryGreaterThan(double amount);
//	
//	List<Salary> findBySalaryLessThan(double amount);
	
	@Override
	public List<Salary> greaterThan(double amount)
	{
		List<Salary> lsalary=sdao.findBySalaryGreaterThan(amount);
		if(lsalary.size()<1)
			throw new RuntimeException("NO SUCH EMLOYEES FOUND");
		return sdao.findBySalaryGreaterThan(amount);
	}
	
	@Override
	public List<Salary> lessThan(double amount)
	{
		List<Salary> lsalary=sdao.findBySalaryLessThan(amount);
		if(lsalary.size()<1)
			throw new RuntimeException("NO SUCH EMLOYEES FOUND");
		return sdao.findBySalaryLessThan(amount);
	}
}
