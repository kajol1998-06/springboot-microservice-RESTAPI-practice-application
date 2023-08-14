package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@PostMapping("/savedata")
	public ResponseEntity<String> saveData()
	{
	    String requestBody="data sucessfully save";
	    ResponseEntity response=new ResponseEntity<String>(requestBody,HttpStatus.CREATED);
		return response;
	}
	
	//costumize response and requestbody
	@GetMapping("/msg")
	public ResponseEntity<String> getMag()
	{
		 String requestBody="Hello I am here....";
		 ResponseEntity response=new ResponseEntity<String>(requestBody,HttpStatus.OK);
		return response;
	}
	@GetMapping("/hello")
	public String getHello()
	{
		return "hello is not customize  response retun by despecher servelet";
	}
	
}
