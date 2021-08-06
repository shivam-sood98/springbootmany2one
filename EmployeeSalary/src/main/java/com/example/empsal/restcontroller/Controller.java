package com.example.empsal.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empsal.entity.Employee;
import com.example.empsal.entity.Gender;
import com.example.empsal.entity.Salary;
import com.example.empsal.repository.EmployeeRepository;
import com.example.empsal.repository.SalaryRepository;
import com.example.empsal.request.EmployeeDto;
import com.example.empsal.service.IEmployeeService;

@RestController
@RequestMapping("employee")
public class Controller {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/all")
	public List<EmployeeDto> getAllEmployee()
	{
		List<EmployeeDto> dtolist=new ArrayList<>();
		service.getAllEmployee().forEach(emp -> dtolist
								.add(service.getDto(emp.getEmployeeId())));

		return dtolist;
	}
	
	@GetMapping("/{id}")
	public EmployeeDto getEmployee(@PathVariable int id)
	{
		//EmployeeDto dto=service.getDto(id);
		return service.getDto(id);
	}
	
	@PostMapping("save")
	public EmployeeDto saveEmployeeWithSalary(@RequestBody EmployeeDto empdto)
	{
		return service.saveEmp(empdto);
	}
	
	@PutMapping("/update")
	public void updateEmployee(@RequestBody EmployeeDto employee)
	{	
		service.saveEmp(employee);
		
		//return service.getDto(employee.getEmployeeId());
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		service.deleteEmpWithSal(id);
	}
	
	@GetMapping("getfilter/{type}/{amount}")
	public List<Employee> showSalary(@PathVariable String type,@PathVariable double amount)
	{	
		return service.filterSalary(type, amount);

	}
	

	@GetMapping("/dto/{id}")
	public EmployeeDto getDto(@PathVariable int id)
	{
		return service.getDto(id);
	}
	
}
