package com.cts.grizzlyspring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzlyspring.bean.Profile;
import com.cts.grizzlyspring.service.LoginService;
import com.cts.grizzlyspring.service.ProductService;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String getHomePage(){
		return "Admin-Login";
	}
	@Autowired
	LoginService loginService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="Admin-Login.html", method=RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute Profile profile,HttpSession session){
		
		ModelAndView modelAndView = new ModelAndView();
		if(loginService.authenticateUserId(profile.getUserId()))
		{
			loginService.setUserStatus(profile.getUserId());
			if(loginService.authenticate(profile.getUserId(),profile.getPassword()))
			{
				if(loginService.getUserStatus(profile.getUserId())>3)
				{
					modelAndView.setViewName("MultipleLoginError");
				}
				else
				{
					Profile profile1=loginService.getUserProfile(profile.getUserId());
					modelAndView.addObject("user", profile1);
					session.setAttribute("user", profile1);
					modelAndView.addObject("products",productService.getAllProducts());
					modelAndView.setViewName("Admin-ListProducts");
				}
			}
			else
			{
				modelAndView.setViewName("Admin-Login");
			}
		}
		else
		{
			modelAndView.setViewName("LoginAuthenticationError");
		}
		return modelAndView;
	}
}
