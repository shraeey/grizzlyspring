package com.cts.grizzlyspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlyspring.bean.Product;
import com.cts.grizzlyspring.dao.ProductDAO;


@Service("productService")
@Transactional(propagation=Propagation.SUPPORTS)

public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public String addProduct(Product product) {
		return productDAO.addProduct(product);
	}
	

	@Override
	public List<Product> getAllProducts() {
		
		return productDAO.getAllProducts();
	}
		
	@Override
	public Product findProduct(String id)
	{
		return productDAO.findProduct(id);
	}
	
	@Override
	public String deleteProduct(String id) {
		// TODO Auto-generated method stub
		return productDAO.deleteProduct(id);
	}
	
	@Override
	public List<Product> filterProducts(String query)
	{
		return productDAO.filterProducts(query);
	}

}
