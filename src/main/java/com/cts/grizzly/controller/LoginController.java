package com.cts.grizzly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzly.bean.Category;
import com.cts.grizzly.bean.Login;
import com.cts.grizzly.service.CategoryService;
import com.cts.grizzly.service.LoginService;
import com.cts.grizzly.service.ProductService;

@Controller
public class LoginController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="Admin-Login.html")
	public String getLogin(){
		return "Admin-Login";
	}
	
	@RequestMapping(value="Admin-Login.html",method=RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute Login login,HttpSession httpSession){
		ModelAndView mav = new ModelAndView();
		Login login1 =loginService.Validate(login);
		if(login1 == null){
			Login login2=loginService.IncreaseCount(login);
			if(login2.getCount()<4)
			mav.setViewName("loginError");
			else
				mav.setViewName("LoginError2");
		}else{
			loginService.resetCount(login1);
		if(login1.getUserType().equals("A")){
			mav.setViewName("Admin-ListProducts");
			mav.addObject("products",productService.getAllProducts());
			httpSession.setAttribute("user", login1);
			List<Category> categories= categoryService.getCategory();
			httpSession.setAttribute("category",categories);
		}
		else if(login1.getUserType().equals("V")){
			mav.setViewName("Vendor-ListProduct");
			httpSession.setAttribute("user", login1);
			mav.addObject("products",productService.getAllProducts());
			List<Category> categories= categoryService.getCategory();
			httpSession.setAttribute("category",categories);
		}else if(login1.getUserType().equals("U")){
			mav.setViewName("Vendor-ListProduct");
			mav.addObject("products",productService.getAllProducts());
			httpSession.setAttribute("user", login1);
			List<Category> categories= categoryService.getCategory();
			httpSession.setAttribute("category",categories);
		}}
		return mav;
	}
@RequestMapping(value="logout.html")
public ModelAndView logout(HttpSession httpSession){
	ModelAndView modelAndView= new ModelAndView();
	httpSession.removeAttribute("user");
	httpSession.invalidate();
	modelAndView.setViewName("Admin-Login");
	return modelAndView;
}
}
