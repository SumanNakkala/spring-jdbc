package com.learn.suman.springdata.jpa;

import java.util.List;

import com.learn.suman.spring.jdbc.domain.Person;

public interface PersonRepositoryCustom {
	
	public  List<Person>  findByName(String name);

}
