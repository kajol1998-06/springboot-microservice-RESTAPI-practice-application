package com.example.MMT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.MMT.Service.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import com.example.MMT.DAO.*;
@Controller
public class TicketController {

	@Autowired
	ServiceImplemention s=new ServiceImplemention();
	
	@PostMapping("/book-Ticket")
	public String bookTicket(@ModelAttribute("pessanger") Passenger pass,Model model)
	{
		System.out.println(pass);
		Ticket t=s.getBook(pass);
		model.addAttribute("msg","ticket booked succesfull id :"+t.getTicketNumber());
		return "index";
	}
	
	@GetMapping("/")
	public  String greeting(Model model)
	{
		model.addAttribute("pessanger", new Passenger());
		return "index";
	}
}
