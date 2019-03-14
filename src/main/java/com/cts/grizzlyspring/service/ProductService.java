package com.cts.grizzlyspring.service;

import com.cts.grizzlyspring.bean.Product;
import java.util.*;
public interface ProductService {
	public String addProduct(Product product);
	public List<Product> getAllProducts();
	public Product findProduct(String id);
	public String deleteProduct(String id);
	public List<Product> filterProducts(String query);
}