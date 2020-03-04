package com.springboot.hibernate.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.hibernate.dao.EmployeeDAO;
import com.springboot.hibernate.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired

	private EmployeeDAO employeeDAO;

	@Override	
	@Transactional
	public List<Employee> findall() {
	
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteByid(theId);
	}

}
