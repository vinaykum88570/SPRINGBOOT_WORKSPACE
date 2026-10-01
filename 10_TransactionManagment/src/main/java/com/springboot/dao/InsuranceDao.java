package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Insurance;

@Repository
public interface InsuranceDao extends JpaRepository<Insurance, Integer> {

}
