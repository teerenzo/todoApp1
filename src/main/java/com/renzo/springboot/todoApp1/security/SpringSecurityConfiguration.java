package com.renzo.springboot.todoApp1.security;

import java.util.Collection;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		Function<String, String> passwordEncoder= input -> passowrdEncoder().encode(input);
		UserDetails userDetail= User.builder().passwordEncoder(passwordEncoder)
				                .username("renzo")
				                .password("dummy")
				                .build();
		return new InMemoryUserDetailsManager(userDetail);
	}
	
	@Bean 
	public PasswordEncoder passowrdEncoder() {
		return new BCryptPasswordEncoder();
	}

}
