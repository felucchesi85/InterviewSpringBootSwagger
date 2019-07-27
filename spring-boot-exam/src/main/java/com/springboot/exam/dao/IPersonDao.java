package com.springboot.exam.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.exam.entities.Person;

public interface IPersonDao extends CrudRepository<Person, Long>{

}
