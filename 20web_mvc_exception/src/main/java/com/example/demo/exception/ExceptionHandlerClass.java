package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.controller.DemoController;

@ControllerAdvice
public class ExceptionHandlerClass {

	private Logger logger=LoggerFactory.getLogger(DemoController.class);
	
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(Exception ex)
	{
		logger.error(ex.getMessage());
		return "error";
	}

}
