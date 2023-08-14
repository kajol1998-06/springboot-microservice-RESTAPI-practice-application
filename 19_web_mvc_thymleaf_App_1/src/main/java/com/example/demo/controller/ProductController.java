package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	ProductRepository pr;
	
	@GetMapping("/edit")
	public String edit(@RequestParam("pid")Integer id,Model model)
	{
	   Optional <Product> findByid=pr.findById(id);
	   if(findByid.isPresent())
	   {
		   Product product=findByid.get();
		   model.addAttribute("msg", "product updated");
		   model.addAttribute("product",product);
		 
		  
		   
	   }	
	
		return "index";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("pid")Integer id,Model model)
	{
		pr.deleteById(id);
		model.addAttribute("msg", "product deleted");
		model.addAttribute("products",pr.findAll());
	
		return "data";
	}
	
	
	@GetMapping("/products")
	public String getAllProduct(Model model)
	{
		List <Product> list=pr.findAll();
		model.addAttribute("products", list);
		
		return "data";
	}
	
	
	@PostMapping("/product")
	public String saveProduct(@Validated @ModelAttribute("product")Product p, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			System.out.print(p);
			return "index";
			
		}		
		p=pr.save(p);
		if(p.getPid()!=null)
			model.addAttribute("msg", "product save");
		
		return "index";
	}
	
	@GetMapping("/")
	public String loadForm(Model model)
	{
		model.addAttribute("product", new Product());
		
		return "index";
	}

}
