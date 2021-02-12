package com.learn.suman.springdata.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.suman.spring.jdbc.domain.Person;

@Repository
@Transactional
 class PersonJPACumstomImpl implements PersonRepositoryCustom {
	
	Logger log = LoggerFactory.getLogger(PersonJPACumstomImpl.class);
	 
	 
	 @Autowired
	 EntityManager entityManager;

	 
	  
	 public List<Person> findByName( String name) {
		// TODO Auto-generated method stub
		 
		 log.info(" I AM HERE ...1");
		 
		 Query query = entityManager.createNativeQuery("select * from Person where  name = ?");
	
		 query.setParameter(1, name);
		 
		 log.info(" I AM HERE ...2");
		 
		 log.info("The result is " + query.getResultList());
		 
		return query.getResultList();
		
		
		
	}

}
