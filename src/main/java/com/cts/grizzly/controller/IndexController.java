package com.cts.grizzly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String AdminLogin(){
		return "Admin-Login";
	}
}
