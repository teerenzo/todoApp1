package com.renzo.springboot.todoApp1.security;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetail= User.withDefaultPasswordEncoder()
				                .username("renzo")
				                .password("dummy")
				                .build();
		return new InMemoryUserDetailsManager(userDetail);
	}

}
