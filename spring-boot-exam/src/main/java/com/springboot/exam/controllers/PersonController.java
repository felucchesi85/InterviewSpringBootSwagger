package com.springboot.exam.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exam.entities.Person;
import com.springboot.exam.services.IPersonService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/person")
public class PersonController {
	

	@Autowired
	private IPersonService personService;
	
	@ApiOperation(value = "Save Person")
	@PostMapping(value="/person", consumes = "application/json")
	public void savePerson(@RequestBody Person person) {
		personService.save(person);
	}
	
	@ApiOperation(value = "Get Average")
	@RequestMapping(value="/personAge")
	public float getAllPersons() {
		List<Person> personList = personService.findAll();
		int ages = 0;
		for(int i=0; i<personList.size();i++) {
			ages += personList.get(i).getAge();
		}
		
		return (ages/personList.size());
	}
	
	@ApiOperation(value = "Get Persons List + Death List")
	@RequestMapping(value="/personsList")
	public List<Person> getAllPerson() {
		List<Person> personList = personService.findAll();
		return personList;
	}
	
	@ApiOperation(value = "Get Person ID")
	@RequestMapping(value="/person/{id}")
	public Optional<Person> getPerson(@PathVariable (name="id") Long id) {
		return personService.findOne(id);
	}

}
