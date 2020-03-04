package com.springboot.hibernate.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hibernate.service.EmployeeService;
import com.springboot.hibernate.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeService.findall();
	}
	
	@GetMapping("/employee/{id}")
	public Employee findById(@PathVariable int theId) {
		
		Employee theEmployee =  employeeService.findById(theId);
		
		if(theEmployee ==null) {
			throw new RuntimeException("Employee id not found" + theId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee (@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String delete(@PathVariable int theId) {
		
		Employee tempEmp = employeeService.findById(theId);
		
		if(tempEmp == null) throw new RuntimeException("Ëmployee id " + theId + " not found");
		
		employeeService.deleteById(theId);
		
		return "deleted employee " + tempEmp.getFirstName() + "from the database";
		
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	

}
