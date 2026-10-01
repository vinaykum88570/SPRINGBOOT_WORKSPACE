package com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.InsuranceDao;
import com.springboot.model.Insurance;

@Service
public class InsuranceServices {

	@Autowired
	private InsuranceDao insDao;
	
	public Insurance registerInsurance(Insurance ins) {
		
		return insDao.save(ins);
	}
	
}
