package com.springboot.hibernate.service;

import java.util.List;

import com.springboot.hibernate.entity.Employee;

public interface EmployeeService {
	
	
	public List<Employee> findall();
	
	public Employee findById(int theId);
	
	public void save (Employee theEmployee);
	
	public void deleteById(int theId);


}
