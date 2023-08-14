package com.kajol.UserDetail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public  Integer id;
	public String name;
	public String password;
}
