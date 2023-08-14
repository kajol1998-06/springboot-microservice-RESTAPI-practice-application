package com.example.microservice.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.feigen.FegienClass;

@RestController
public class RestControllerClass {
	
	@Autowired
    private FegienClass FC;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		String ans=FC.getotherAPI();
		return ans +"welcome to my world";
	}

}
