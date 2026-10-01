package com.springboot.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {

}