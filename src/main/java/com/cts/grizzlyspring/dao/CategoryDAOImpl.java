package com.cts.grizzlyspring.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlyspring.bean.Category;

@Repository("categoryDAO")
@Transactional(propagation=Propagation.SUPPORTS)
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	@Override
	@Transactional(readOnly=true)
	public List<Category> getCategory() {
		try{
		Session session=sessionFactory.getCurrentSession();
		String query="from Category";
		Query<Category> query2=session.createQuery(query);
		return query2.getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
