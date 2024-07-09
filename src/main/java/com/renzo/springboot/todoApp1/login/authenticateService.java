package com.renzo.springboot.todoApp1.login;

import org.springframework.stereotype.Service;

@Service
public class authenticateService {
	
	public boolean authenticate(String name, String password) {
		boolean isUsername = name.equalsIgnoreCase("renzo");
		boolean isPasswordCorrect = password.equalsIgnoreCase("123");
		return isUsername&&isPasswordCorrect;
	}

}
