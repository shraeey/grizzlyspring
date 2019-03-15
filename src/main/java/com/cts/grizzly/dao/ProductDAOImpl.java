package com.cts.grizzly.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly.bean.Category;
import com.cts.grizzly.bean.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ProductDAO productDAO;
	private Object String;
	
	@Override
	public String addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return "success";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public List<Product> getAllProducts() {
		Query<Product> query2= sessionFactory.getCurrentSession().createQuery("from Product");
		ArrayList<Product> product=(ArrayList<Product>) query2.getResultList();
		return product;
	}

	@Override
	public Product getProduct(String id) {
		// TODO Auto-generated method stub
		Product product = null;
		try {
			product= sessionFactory.getCurrentSession().load(Product.class, id);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println(product);
		return product;
	}

	@Override
	public String deleteProduct(String productId) {
		// TODO Auto-generated method stub
		try {
			Product product= productDAO.getProduct(productId);
			sessionFactory.getCurrentSession().delete(product);
			return "success";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public List<Product> filterProducts(String query) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		String query1 = "from Product order by rating";
		if("HTL".equals(query)){
		query1 = "from Product order by rating desc";}
		else if("LTH".equals(query)){
			query1 = "from Product order by rating";}
		org.hibernate.query.Query<Product> query2 = null;
		System.out.println(query1);
		query2 = session.createQuery(query1);
		List<Product> products= query2.getResultList();
		return products;
	}

	@Override
	public String updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return "success";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	

}
