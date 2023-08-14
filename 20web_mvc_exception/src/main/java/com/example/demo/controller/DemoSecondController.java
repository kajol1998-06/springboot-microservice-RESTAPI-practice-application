package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoSecondController {

	@GetMapping("/hello")
	public String getWelcome(Model model)
	{
		String msg="welcome to the house";
		String s=null;
		int i=s.length();
		model.addAttribute("msg", msg);
		return "index";
	}
}
