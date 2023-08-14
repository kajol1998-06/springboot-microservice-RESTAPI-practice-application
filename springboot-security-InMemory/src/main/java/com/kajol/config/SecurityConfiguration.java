package com.kajol.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager configUser()
	{
		UserDetails adminUser = User.withDefaultPasswordEncoder()
				.username("raja")
				.password("ashok@123")
				.authorities("ADMIN")
				.build();
		UserDetails normalUser = User.withDefaultPasswordEncoder()
				.username("ashok")
				.password("raja@123")
				.authorities("USER")
				.build();

         return new InMemoryUserDetailsManager(adminUser, normalUser);
	}
	@Bean
	public SecurityFilterChain secury(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((req)-> req.antMatchers("/welcome").permitAll().anyRequest().authenticated()).formLogin();
		return http.build();
	}
}
