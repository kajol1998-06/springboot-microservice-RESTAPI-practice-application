package com.kajol.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kajol.UserDetail.MyJpa;
import com.kajol.UserDetail.UserDetail;

@RestController
public class RestControllerForUser {
    
	@Autowired
	private MyJpa jpa;
	
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
	
	@PostMapping("/user")
	public String dataInsert(@RequestBody UserDetail user)
	{
	    jpa.save(user);	
		return "data interted";
	}
}
