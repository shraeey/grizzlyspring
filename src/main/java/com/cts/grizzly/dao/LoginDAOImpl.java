package com.cts.grizzly.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly.bean.Login;

import org.hibernate.HibernateException;
import org.hibernate.Session;

@Repository("loginDAO")
@Transactional
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	LoginDAO dao;
	
	@Override
	@Transactional(readOnly=true)
	public Login Validate(Login login) {
	try {
		String userName= login.getUserId();
		String password= login.getPassword();
		Session session= sessionFactory.getCurrentSession();
		String query = "from Login where userId=? and password=?";
		org.hibernate.query.Query<Login> query2 = null;
		query2 = session.createQuery(query);
		query2.setParameter(0, userName);
		query2.setParameter(1, password);
		Login login2= query2.getSingleResult();
			return login2;
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
		return null;
	}
 	}

	@Override
	public String register(Login login) {
		try {
			sessionFactory.getCurrentSession().save(login);
			return "success";
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Login IncreaseCount(Login login) {
		// TODO Auto-generated method stub
		Login login2 = null;
		try {
			Session session= sessionFactory.getCurrentSession();
			String query = "from Login where userId=?";
			String userName= login.getUserId();
			org.hibernate.query.Query<Login> query2 = null;
			query2 = session.createQuery(query);
			query2.setParameter(0, userName);
			login2 = query2.getSingleResult();
			if(query2.getSingleResult() != null){
				int i=login2.getCount();
				login2.setCount(i+1);
				sessionFactory.getCurrentSession().saveOrUpdate(login2);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return login2;
	}

	@Override
	public void resetCount(Login login) {
		// TODO Auto-generated method stub
		login.setCount(0);
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(login);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
