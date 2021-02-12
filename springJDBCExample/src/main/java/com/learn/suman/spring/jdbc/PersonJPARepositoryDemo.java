package com.learn.suman.spring.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.suman.spring.jdbc.domain.Person;

@Repository
@Transactional
public class PersonJPARepositoryDemo {
	
	@Autowired
	EntityManager entityManager;
	
	// finding
	public Person FindById(int id) {
		
		return entityManager.find(Person.class, id);
	}
	
	
	// inserting
	public void insertPerson( Person p) {
		
		entityManager.merge(p);
	}
	
	// deleting 
	
	public void deletePerson(int id) {
		
		
	  Person person = FindById(id);
		
		entityManager.remove(person);
	}
	
	
	public List<Person> getAllPersons(){
		
		
		TypedQuery<Person> createNamedQuery = entityManager.createNamedQuery("get_all_persons", Person.class);
		
		return createNamedQuery.getResultList();
		
		
	}
	
	
	
	

}
