package com.learn.suman.springdata.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.suman.spring.jdbc.domain.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>,PersonRepositoryCustom {
	
	
	

}
