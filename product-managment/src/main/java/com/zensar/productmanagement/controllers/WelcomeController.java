package com.zensar.productmanagement.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {  // Multi - action controller

	// http://localhost:7000/

	@RequestMapping("/")  //handler method
	public String sayHello() {
		return "<h2> Spring Boot </h2>";
	}
	
	@RequestMapping("/bye")
	public String sayBye() {
		return "<h2> Bye </h2>";
	}

}
