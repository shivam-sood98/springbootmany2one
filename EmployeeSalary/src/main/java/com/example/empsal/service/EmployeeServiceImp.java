package com.example.empsal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.empsal.entity.Employee;
import com.example.empsal.entity.Salary;
import com.example.empsal.repository.IEmployeeRepository;
import com.example.empsal.repository.SalaryRepository;
import com.example.empsal.request.EmployeeDto;
import com.example.empsal.exception.UserNotFoundException;

@Service
public class EmployeeServiceImp implements IEmployeeService {

	@Autowired
	private IEmployeeRepository repo;
	
	@Autowired
	private SalaryRepository srepo;
	
	
	@Override
	public Employee getEmployee(int id) {
	
		return repo.findById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return repo.getAllemp();
	}

	@Override
	public void save(Employee employee) {
		
		repo.save(employee);
	}

	@Override
	public void delete(Employee emp) {
		repo.delete(emp);
	}

	@Override
	public List<Employee> filterSalary(String type, double amount) {
		List<Salary> list=new ArrayList<Salary>();
		List<Employee> elist=new ArrayList<Employee>();
		
		if(type.equals("greater"))
		{
			try {
			list=repo.greaterThan(amount);
			}
			catch(Exception e)
			{
				System.out.println("SORRY NO SUCH EMPLOYEES ARE PRESENT");
			}
			list.forEach(sal-> elist.add(sal.getEmployee()));
		}
		else if(type.equals("lesser"))
		{
				try {
					list=repo.lessThan(amount);
					}
				catch(Exception e)
				{
					System.out.println("SORRY NO SUCH EMPLOYEES ARE PRESENT");
				}
			list.forEach(obj-> elist.add(obj.getEmployee()));
		}
		
		return elist;
	}

	@Override
	public EmployeeDto getDto(int id) 
	{
		EmployeeDto dto=new EmployeeDto();

		Salary sal=null;
		try {
		sal=repo.getSalaryFromEmpId(id);
		Employee e=sal.getEmployee();
		
		BeanUtils.copyProperties(e,dto);
		dto.setSalary(sal.getSalary());
		}
		catch(Exception e)
		{
			System.out.println("SORRY EMPLOYEE NOT FOUND");
		}
		
		
			
		return dto;
	}

	@Override
	public void saveSalary(Salary sal) {
		srepo.save(sal);
		
	}
	
	@Override
	public EmployeeDto saveEmp(EmployeeDto empdto) 
	{
		Employee emp=new Employee();
		Salary sal=new Salary();
		BeanUtils.copyProperties(empdto, emp);
		BeanUtils.copyProperties(empdto, sal);
		sal.setEmployee(emp);
		saveSalary(sal);
		return getDto(emp.getEmployeeId());
	}
	
	@Override
	public void deleteEmpWithSal(int id)
	{
		try {
		Salary sal=repo.getSalaryFromEmpId(id);
		Employee emp=sal.getEmployee();
		
		repo.delete(emp);
		srepo.delete(sal);
		}
		catch(Exception e)
		{
			System.out.println("Sorry no employee found with id :"+id);
		}
	}
	
}
