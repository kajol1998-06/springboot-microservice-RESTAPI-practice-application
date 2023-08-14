package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	
	
	@GetMapping("/welcome")
	public String getWelcome(Model model)
	{
		String msg="Welcome to here....";
		model.addAttribute("msg", msg);
		return "index";
	}
	
	
	@GetMapping("/wish")
	public String getGreet(Model model)
	{
		String msg="Goode Morning!";
		int i=10/0;
		model.addAttribute("msg", msg);
		return "index";
	}
	
}
