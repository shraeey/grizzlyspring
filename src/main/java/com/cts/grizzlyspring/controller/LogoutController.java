package com.cts.grizzlyspring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzlyspring.bean.Profile;
import com.cts.grizzlyspring.service.LoginService;

@Controller
public class LogoutController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="Logout.html")
	public ModelAndView logoutUser(HttpSession session){
		Profile profile= (Profile) session.getAttribute("user");
		loginService.resetUserStatus(profile.getUserId());
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Admin-Login");
		
		return modelAndView;
}
}
