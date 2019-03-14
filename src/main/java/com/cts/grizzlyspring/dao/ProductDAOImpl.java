package com.cts.grizzlyspring.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlyspring.bean.Product;
@Repository("productDAO")
@Transactional(propagation=Propagation.SUPPORTS)

public class ProductDAOImpl implements ProductDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public String addProduct(Product product) {

		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(product);
			return "success";
		}catch(Exception e)
		{
			e.printStackTrace();
			return "failed";
		}
	
		
		
	}
	@Override
	@Transactional(readOnly=true)
	public List<Product> getAllProducts() {
		

		Session session=sessionFactory.getCurrentSession();
		String query="from Product";
		Query<Product> query2=session.createQuery(query);
		List<Product> products=query2.getResultList();
		return products;
	
	}
	
	@Override
	@Transactional(readOnly=true)
	public Product findProduct(String id) {
		try{
		Session session=sessionFactory.getCurrentSession();
		String query="from Product where id=?";
		Query<Product> query2=session.createQuery(query);
		query2.setParameter(0, id);
		Product product=query2.getSingleResult();
		return product;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	
	}
	
	@Override
	@Transactional
	public String deleteProduct(String id) {
		try{
		Session session=sessionFactory.getCurrentSession();
		String query="from Product where id=?";
		Query<Product> query2=session.createQuery(query);
		query2.setParameter(0, id);
		session.delete(query2);
		return "success";
		}catch(Exception e)
		{
			e.printStackTrace();
			return "false";
		}
	}
	
	@Override
	public List<Product> filterProducts(String query)
	{
//		List<Product> products = new ArrayList<Product>();
//		PreparedStatement preparedStatement=null;
//		ResultSet resultSet= null;
//		Product product = null;
//		
//		try {
//			connection = DBUtils.getConnection();
//			preparedStatement = connection.prepareStatement(query);
//			resultSet = preparedStatement.executeQuery();
//			while(resultSet.next()){
//				String id = resultSet.getString("productid");
//				String category = resultSet.getString("category");
//				String name = resultSet.getString("name");
//				String description = resultSet.getString("description");
//				Float price = resultSet.getFloat("price");
//				String brand = resultSet.getString("brand");
//				String offer = resultSet.getString("offer");
//				String rating = resultSet.getString("rating");
//				product = new Product(id,category,name,description,price,brand,offer,rating);
//				products.add(product);
//			}
//			return products;
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			DBUtils.closeConnection(connection);
//		}
//		
//		
		return null;
	}
	
}