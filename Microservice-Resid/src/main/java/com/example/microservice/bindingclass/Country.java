package com.example.microservice.bindingclass;

import java.io.Serializable;

import lombok.Data;

@Data
public class Country implements Serializable {

	private Integer sno;
	private String name;
	private String code;
	
}
