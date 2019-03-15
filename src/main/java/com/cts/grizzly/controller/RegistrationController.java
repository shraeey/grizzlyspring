package com.cts.grizzly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.grizzly.bean.Login;
import com.cts.grizzly.service.LoginService;

@Controller
public class RegistrationController {

	@Autowired
	LoginService loginservice;
	
	@RequestMapping(value="registration.html")
	public String getregistration(){
		return "registration";
	}
	
	@RequestMapping(value="registration.html", method=RequestMethod.POST)
	public String Registeration(@ModelAttribute Login login){
		String string=loginservice.register(login);
		if(string=="success"){
			return "registered";
		}else{
			return "registration";
		}
	}
}
