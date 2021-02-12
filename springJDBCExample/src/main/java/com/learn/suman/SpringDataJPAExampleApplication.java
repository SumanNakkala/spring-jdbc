package com.learn.suman;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.suman.spring.jdbc.domain.Person;
import com.learn.suman.springdata.jpa.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataJPAExampleApplication implements CommandLineRunner{
	
	Logger log = LoggerFactory.getLogger(SpringDataJPAExampleApplication.class);
	
	@Autowired
	PersonSpringDataRepository jdbcDao;

	public static void main(String[] args) {
		
		
		
		SpringApplication.run(SpringDataJPAExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("HELLO I AM RUNNING");
		
		
		log.info("----> " + jdbcDao.findById(10001) );
		
		Person p = new Person(); 
		p.setName("Phani");
		  p.setLocation("ABCD"); p.setBirthDate(new Date());
		
		  jdbcDao.save(p);
		  //org.springframework.data.repository.CrudRepository.deleteById(Integer id)

		  
		  jdbcDao.deleteById(10003);
		  
		  log.info("All  person details  are - > " + jdbcDao.findAll());
		  
		  System.out.println("Name results " + jdbcDao.findByName("Ranga"));
		
		
		/*
		 * log.info("All person Details are  {}" + jdbcDao.findAll());
		 * 
		 * log.info("Details of 10001 -> {} " + jdbcDao.findById(10001,"Ranga"));
		 * 
		 * log.info("Deleting the 10001 and number of rows effected " +
		 * jdbcDao.deleteById(10008));
		 * 
		 * 
		 * Person p = new Person(); p.setId(10007); p.setName("Phani");
		 * p.setLocation("ABCD"); p.setBirthDate(new Date());
		 * 
		 * 
		 * log.info("Inserritng Person rows effected is   -> " + jdbcDao.insert(p));
		 * //System.out.println(jdbcDao.findAll());
		 * 
		 * p.setLocation("MUMBAI");
		 * 
		 * 
		 * log.info("Updating person " + jdbcDao.update(p));
		 */
		
		
		
	}

}