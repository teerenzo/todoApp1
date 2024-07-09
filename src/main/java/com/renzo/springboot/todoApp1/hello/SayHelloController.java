package com.renzo.springboot.todoApp1.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("hello")
	@ResponseBody
	public String sayHello() {
		return "Hello world";
	}
	
	@RequestMapping("hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		  StringBuffer htmlContent = new StringBuffer();
	        htmlContent.append("<!DOCTYPE html>\n");
	        htmlContent.append("<html lang=\"en\">\n");
	        htmlContent.append("<head>\n");
	        htmlContent.append("    <meta charset=\"UTF-8\">\n");
	        htmlContent.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
	        htmlContent.append("    <title>Document</title>\n");
	        htmlContent.append("</head>\n");
	        htmlContent.append("<body>\n");
	        htmlContent.append("    My first java spring boot project\n - Changed");
	        htmlContent.append("</body>\n");
	        htmlContent.append("</html>\n");
		return htmlContent.toString();
	}
	
	@RequestMapping("hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	


}
