package com.cts.grizzly.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzly.bean.Category;
import com.cts.grizzly.bean.Product;
import com.cts.grizzly.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="Admin-AddProduct.html")
	public String getAddProduct(){
		return "Admin-AddProduct";
	}
	@RequestMapping(value="viewProduct.html")
	public ModelAndView getViewProduct(@RequestParam("id") String id,HttpSession httpSession){
		ModelAndView mav = new ModelAndView();
		Product product= productService.findProduct(id);
		mav.addObject("product",product);
		mav.setViewName("Admin-ViewProduct");
		return mav;
	}
	@RequestMapping(value="deleteProduct.html")
	public ModelAndView getDeleteProduct(@RequestParam("id") String id){
		ModelAndView mav= new ModelAndView();
		mav.setViewName("Admin-ListProducts");
		String s=productService.deleteProduct(id);
		List<Product> product= productService.getAllProducts();
		mav.addObject("product",product);
		return mav;
	}
	
	@RequestMapping(value="Add-Product.html",method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute Product product, HttpSession httpSession){
		String s=productService.addProduct(product);
		ModelAndView modelAndView = new ModelAndView();
		if(s=="success")
		{
		modelAndView.setViewName("Admin-ListProducts");
		modelAndView.addObject("products",productService.getAllProducts());
		}
		else{
			modelAndView.setViewName("Admin-AddProduct");
		}
		
		
		return modelAndView;
	}
	
	@RequestMapping(value="sortByRating.html")
	public ModelAndView Sort(@RequestParam("order") String order){
		ModelAndView modelAndView = new ModelAndView();
		List<Product> products=productService.filterProducts(order);
		modelAndView.setViewName("Admin-ListProducts");
		modelAndView.addObject("products",products);
		return modelAndView;
	}
	@RequestMapping(value="AddProductVendor.html")
	public String getAddProductVendor(){
		return "Vendor-AddProduct";
	}
	@RequestMapping(value="AddProductVendor.html",method=RequestMethod.POST)
	public ModelAndView addProductVendor(@ModelAttribute Product product, HttpSession httpSession){
		String s=productService.addProduct(product);
		ModelAndView modelAndView = new ModelAndView();
		if(s=="success")
		{
		modelAndView.setViewName("Vendor-ListProduct");
		modelAndView.addObject("products",productService.getAllProducts());
		}
		else{
			modelAndView.setViewName("Vendor-AddProduct");
		}
		
		
		return modelAndView;
	}
}
