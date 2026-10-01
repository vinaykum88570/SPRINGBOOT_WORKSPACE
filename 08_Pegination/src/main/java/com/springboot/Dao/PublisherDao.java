package com.springboot.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Publisher;


@Repository
public interface PublisherDao extends CrudRepository<Publisher, Integer> {

}
