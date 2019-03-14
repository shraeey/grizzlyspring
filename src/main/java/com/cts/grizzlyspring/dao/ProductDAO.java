package com.cts.grizzlyspring.dao;

import java.util.List;

import com.cts.grizzlyspring.bean.Product;

public interface ProductDAO {
	public String addProduct(Product product);
	public List<Product> getAllProducts();
	public Product findProduct(String id);
	public String deleteProduct(String id);
	public List<Product> filterProducts(String query);
}
