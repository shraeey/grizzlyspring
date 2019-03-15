package com.cts.grizzly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.grizzly.bean.Product;
import com.cts.grizzly.dao.ProductDAO;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.addProduct(product);
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}

	public Product findProduct(String id) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(id);
	}

	public String deleteProduct(String productId) {
		// TODO Auto-generated method stub
		return productDAO.deleteProduct(productId);
	}

	public List<Product> filterProducts(String query) {
		// TODO Auto-generated method stub
		return productDAO.filterProducts(query);
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.updateProduct(product);
	}

}
