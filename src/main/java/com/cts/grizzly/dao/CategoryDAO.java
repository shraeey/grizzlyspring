package com.cts.grizzly.dao;

import java.util.List;

import com.cts.grizzly.bean.Category;
import com.cts.grizzly.bean.Product;

public interface CategoryDAO {
	public List<Category> getCategory();
	public List<Product> getProducts(String name);
}
