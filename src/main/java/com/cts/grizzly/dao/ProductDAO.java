package com.cts.grizzly.dao;

import java.util.List;

import com.cts.grizzly.bean.Product;


public interface ProductDAO {
	public String addProduct(Product product);
	public List<Product> getAllProducts();
	public Product getProduct(String id);
	public String deleteProduct(String productId);
	public List<Product> filterProducts(String query);
	public String updateProduct(Product product);
}
