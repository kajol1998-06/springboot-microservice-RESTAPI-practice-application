package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*; 
import com.example.demo.dao.EmployeeData;

@RestController
public class JsonController {
	
	private Map<Integer, EmployeeData> dataMap = new HashMap<>();
	
	@PostMapping("/save")
	public ResponseEntity<String> getData(@RequestBody EmployeeData emp)
	{
		System.out.println(emp);
		dataMap.put(emp.getId(),emp);
		return new ResponseEntity<String>("datasave",HttpStatus.OK);
	}
}
