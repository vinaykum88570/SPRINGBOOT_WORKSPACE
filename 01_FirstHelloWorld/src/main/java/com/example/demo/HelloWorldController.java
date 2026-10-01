package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {


	@RequestMapping(value="/")
	public String getHelloWorld() {
		return "welcome to Spring Boot Application";
	}
}
