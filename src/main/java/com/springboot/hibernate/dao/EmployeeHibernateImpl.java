package com.springboot.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.hibernate.entity.Employee;

@Repository
public class EmployeeHibernateImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
//	@Autowired
//	public EmployeeHibernateImpl(EntityManager theEntityManager) {
//		this.entityManager = theEntityManager;
//	}
	

	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create the query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//create a results list
		List<Employee> employees =  theQuery.getResultList();
		
		return employees;
	}


	@Override
	public Employee findById(int theId) {
		
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		
		Employee theEmployee = currentSession.get(Employee.class, theId);


		
		return theEmployee;
	}


	@Override
	public void save(Employee theEmployee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmployee);

		
	}


	@Override
	public void deleteByid(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
