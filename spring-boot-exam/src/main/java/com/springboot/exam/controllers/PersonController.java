package com.springboot.exam.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.springboot.exam.entities.KpiCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.exam.entities.Person;
import com.springboot.exam.services.IPersonService;

import io.swagger.annotations.ApiOperation;

@RestController
public class PersonController {


	@Autowired
	private IPersonService personService;
	
	@ApiOperation(value = "Save Person")
	@PostMapping(value="/person", consumes = "application/json")
	public void savePerson(@RequestBody Person person) {
		personService.save(person);
	}
	
	@ApiOperation(value = "Get Average")
	@RequestMapping(value="/personAge", method = RequestMethod.GET)
	public float getAllPersons() {
		List<Person> personList = personService.findAll();
		int ages = 0;
		for(int i=0; i<personList.size();i++) {
			ages += personList.get(i).getAge();
		}
		
		return (ages/personList.size());
	}

	@ApiOperation(value = "Get Average")
	@RequestMapping(value="/personDeviation", method = RequestMethod.GET)
	public double getStandardDeviation()
	{
		double sum = 0.0, standardDeviation = 0.0;
		List<Person> personList = personService.findAll();
		double edades = 0;
		int length = personList.size();
		for(Person person : personList) {  //suma todas las edades
			edades+=person.getAge();
		}

		double media = edades/length;    //calcula la media de las edades
		for(Person person: personList) {
			standardDeviation += Math.pow(person.getAge() - media, 2);
		}

		return Math.sqrt(standardDeviation/length);

	}


	@ApiOperation(value = "Get Average")
	@RequestMapping(value="/standardDeviation", method = RequestMethod.GET)
	public KpiCliente getDeviationAndMedia ()
	{
		KpiCliente kpi = new KpiCliente();
		double sum = 0.0, standardDeviation = 0.0;
		List<Person> personList = personService.findAll();
		double edades = 0;
		int length = personList.size();
		for(Person person : personList) {  //suma todas las edades
			edades+=person.getAge();
		}

		double media = edades/length;    //calcula la media de las edades
		kpi.setPromedio(media);


		for(Person person: personList) {
			standardDeviation += Math.pow(person.getAge() - media, 2);
		}

		kpi.setDesviacion(Math.sqrt(standardDeviation/length));
		return kpi;

	}
	
	@ApiOperation(value = "Get Persons List + Death List")
	@RequestMapping(value="/personsList", method = RequestMethod.GET)
	public List<Person> getAllPerson() {
		List<Person> personList = personService.findAll();
		return personList;
	}


	@ApiOperation(value = "Get Person ID")
		@RequestMapping(value="/person/{id}", method = RequestMethod.GET)
	public Optional<Person> getPerson(@PathVariable (name="id") Long id) {
		return personService.findOne(id);
	}

}
