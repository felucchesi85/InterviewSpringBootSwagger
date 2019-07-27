package com.springboot.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.exam.dao.IPersonDao;
import com.springboot.exam.entities.Person;

@Service
public class PersonServiceImpl implements IPersonService{

	@Autowired
	private IPersonDao personDao;
	
	@Override
	public List<Person> findAll() {
		return (List<Person>) personDao.findAll();
	}

	@Override
	@Transactional(readOnly=false)
	public void save(Person person) {
		if(person != null) {
			personDao.save(person);
		}
		
	}

	@Override
	public Optional<Person> findOne(Long id) {
			return personDao.findById(id);
	}

}
