package com.springboot.hibernate.dao;

import java.util.List;

import com.springboot.hibernate.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteByid(int theid);

}
