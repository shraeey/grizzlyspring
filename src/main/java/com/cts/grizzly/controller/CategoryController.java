package com.cts.grizzly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzly.bean.Category;
import com.cts.grizzly.bean.Product;
import com.cts.grizzly.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="fetchCategory")
	public ModelAndView fetchCategory(@ModelAttribute Category category){
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("Admin-ListProducts");
	List<Product> products= categoryService.getProducts(category.getName());
	modelAndView.addObject("products",products);
		return modelAndView;
	}
}
