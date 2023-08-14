package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue
	private Integer pid;
	@NotBlank(message="name is mandatory")
	private String name;
	@NotNull(message="price is mandatory")
	private Double price;
	@NotNull(message="qauntity is mandatory")
	private Integer qnt;
	

}
