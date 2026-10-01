package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.sprintboot.beans.Hospital;

@SpringBootApplication
@ComponentScan("com")
public class ValueAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(ValueAnnotationApplication.class, args);
		
		Hospital hospital = container.getBean("hsptl",Hospital.class);
		
		System.out.println("Spring Bean class obj data :"+ hospital.getAge());
		
		((ConfigurableApplicationContext)container).close();
		System.out.println("====================================");
		System.out.println("System  Properties :"+ System.getProperties());
		
	}

}
