package com.java.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Product;

@Controller
public class LoginController {
	
	@RequestMapping("/welcome")
	public String getWelcomePage() {
		return "welcome"; //view name (html/jsp)
	}
/*	Request

	accept: text/html

	client (browser/ postman) : is looking out for a data in this format

	accept: application/xml: xml
		application/json: json*/
	@RequestMapping("/welcome-data")
	@ResponseBody
	public String getWelcomeResponse() {
		return "welcome"; //data which has to be returned
	}
	
	//Json => java MappingJackson2HttpMessageConverter
	@PostMapping(path="/welcome-data", 
			consumes= {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
			produces= {MediaType.TEXT_PLAIN})
	@ResponseBody
	public String getWelcomeResponse(@RequestBody Product product) {
		System.out.println(product);
		System.out.println("in!!");
		return product.toString(); //data which has to be returned
	}
	
	@RequestMapping("/form")
	public String getformPage() {
		return "form";
	}
}
