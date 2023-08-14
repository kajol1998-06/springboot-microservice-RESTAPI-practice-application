package com.kajol.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigurationSecurity {

	@Bean
	public SecurityFilterChain secury(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((req)-> req.antMatchers("/welcome","/h2-console").permitAll().anyRequest().authenticated()).formLogin();
		return http.build();
	}
}
