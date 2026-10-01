package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.sprintboot.beans.CustomerInfo;



@SpringBootApplication
@ComponentScan("com")
public class ConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(ConfigurationPropertiesAnnotationApplication.class, args);
		
		CustomerInfo info  = container.getBean("custInfo",CustomerInfo.class);
		
		System.out.println("Customer info object data"+info);
	}	

}
