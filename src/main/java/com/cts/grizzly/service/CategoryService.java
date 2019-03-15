package com.cts.grizzly.service;

import java.util.List;

import com.cts.grizzly.bean.Category;
import com.cts.grizzly.bean.Product;

public interface CategoryService {
	public List<Category> getCategory();
	public List<Product> getProducts(String name);
}
