package com.cts.grizzlyspring.controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzlyspring.bean.Product;
import com.cts.grizzlyspring.service.CategoryService;
import com.cts.grizzlyspring.service.ProductService;



@Controller
@Transactional
public class ProductController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;

	@RequestMapping(value="Admin-AddProduct.html")
	public ModelAndView getaddProduct()
	{
		
		ModelAndView modelandview=new ModelAndView();
		modelandview.addObject("category", categoryService.getCategory());
		modelandview.setViewName("Admin-AddProduct");
		return modelandview;
	}
	
	@RequestMapping(value="Admin-AddProduct.html",method=RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute Product product)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("product", productService.addProduct(product));
		modelAndView.setViewName("Admin-AddProduct");
		return modelAndView;
	}
}
