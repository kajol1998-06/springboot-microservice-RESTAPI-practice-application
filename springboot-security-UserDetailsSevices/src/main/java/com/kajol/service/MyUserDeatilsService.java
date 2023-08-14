package com.kajol.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kajol.UserDetail.MyJpa;
import com.kajol.UserDetail.UserDetail;
@Service
public class MyUserDeatilsService implements UserDetailsService {

	@Autowired
	private MyJpa jpa;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserDetail user=jpa.findByName(username);
		System.out.println(username);
		return new User(user.getName(),user.getPassword(), Collections.emptyList());
	}

}
