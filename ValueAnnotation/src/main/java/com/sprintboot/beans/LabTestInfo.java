package com.sprintboot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("labinfo")
@Data
public class LabTestInfo {

	@Value("${lab.bpPrice}")
	private float bloodProfilePrice;

	@Value("${lab.rtpcrPrice}")
	private float rtpcrPrice;
	
	@Value("${lab.echo2DPrice}")
	private float eco2DPrice;
	
}
