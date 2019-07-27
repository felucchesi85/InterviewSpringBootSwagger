package com.springboot.exam.services;

import java.util.List;
import java.util.Optional;

import com.springboot.exam.entities.Person;

public interface IPersonService {

	public List<Person> findAll();
	
	public void save(Person person);

	public Optional<Person> findOne(Long id);

}
