package com.kajol.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.kajol.service.MyUserDeatilsService;

@Configuration
@EnableWebSecurity
public class UserConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public MyUserDeatilsService userdetails;
	
	@Autowired
	public void congif(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(userdetails).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
	        .antMatchers("/h2-console/**").permitAll() // Allow access to H2 Console without authentication
	        .anyRequest().authenticated()
	        .and()
			    .formLogin().and()
			    .csrf().ignoringAntMatchers("/h2-console/**") // Disable CSRF for H2 Console
			    .and()
			    .headers().frameOptions().sameOrigin(); 
	}
	
}
