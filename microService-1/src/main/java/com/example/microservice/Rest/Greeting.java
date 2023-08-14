package com.example.microservice.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
	
	@Autowired
	private Environment env;

	@GetMapping("/greet")
	public String greeting()
	{
		String port=env.getProperty("server.port");
		return "good morning ("+port+" )";
	}
}
