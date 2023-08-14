package com.kajol.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@GetMapping("/hello")
	public String getPage()
	{
		return "hey, How are you!";
	}
	
	@GetMapping("/welcome")
	public String publicmethodh()
	{
		return "welcome";
	}
	
}
