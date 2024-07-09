package com.renzo.springboot.todoApp1.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	private authenticateService auth;
	
	
	
	public LoginController(authenticateService auth) {
		super();
		this.auth = auth;
	}

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String loginpost(@RequestParam String name,@RequestParam String password, ModelMap model) {
		if(auth.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
		else {
			model.put("error", "Invalid Credentials");
			return "login";
		}
	
	}


}
