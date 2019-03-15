package com.cts.grizzly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly.bean.Category;
import com.cts.grizzly.bean.Product;
import com.cts.grizzly.dao.CategoryDAO;
@Service("categoryService")
@Transactional(propagation=Propagation.SUPPORTS)
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return categoryDAO.getCategory();
	}

	@Override
	public List<Product> getProducts(String name) {
		// TODO Auto-generated method stub
		return categoryDAO.getProducts(name);
	}

}
