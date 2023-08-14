package com.kajol.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@GetMapping("/")
	public String welcome()
	{
		return "Hi, HOw are you!";
	}
	
	
}
