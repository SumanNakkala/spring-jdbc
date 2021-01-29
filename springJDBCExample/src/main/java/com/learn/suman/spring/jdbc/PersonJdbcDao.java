package com.learn.suman.spring.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.suman.spring.jdbc.domain.Person;

//@Component

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public  List<Person> findAll() {
		
		
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
		
		
	}
	
	@SuppressWarnings("deprecation")
	public Person findById(int id, String name){
		
		return (jdbcTemplate.queryForObject("select * from person where id = ? and name = ?", new Object[] {id,name},new BeanPropertyRowMapper<Person>(Person.class)));
		
		
	}
	
	@SuppressWarnings("deprecation")
	public int deleteById(int id){
		
		return jdbcTemplate.update("delete from person where id = ?", new Object[] {id});
		
		
	}
	
	
	// insering the new record
	
	public int  insert(Person person) {
		
	return 	jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) Values ( ?, ? , ? , ? )" , 
				new Object[] {person.getId(),person.getName(),person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
		
		
		
	}
	
	
	
	//updtae the record 
	
	
	public int  update(Person person) {
		
		return 	jdbcTemplate.update("Update PERSON set location = ? where id = ?" , 
					new Object[] {person.getLocation(), person.getId()});
			
			
			
		}
	
	
	
	
	
	
	

}
