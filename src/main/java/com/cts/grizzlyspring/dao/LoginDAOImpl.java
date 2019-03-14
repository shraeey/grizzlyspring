package com.cts.grizzlyspring.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlyspring.bean.Profile;

@Repository("loginDAO")
@Transactional(propagation=Propagation.SUPPORTS)
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;

	@Override
	@Transactional(readOnly=true)
	public int getUserStatus(String userId) {
		try{
		Session session=sessionFactory.getCurrentSession();
		String query="from Profile where userId=?";
		Query<Profile> query2=session.createQuery(query);
		query2.setParameter(0, userId);
		Profile profile=query2.getSingleResult();
		return profile.getStatus();
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		
	}
	@Override
	@Transactional(readOnly=true)
	public String getUserType(String userId,String password) {
		try{
		Session session=sessionFactory.getCurrentSession();
		String query="from Profile where userId=? and password=?";
		Query<Profile> query2=session.createQuery(query);
		query2.setParameter(0, userId);
		query2.setParameter(1, password);
		Profile profile=query2.getSingleResult();
		return profile.getUserType();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@Override
	@Transactional(readOnly=true)
	public boolean authenticate(String userId,String password)
	{
		try{
		Session session=sessionFactory.getCurrentSession();
		String query="from Profile where userId=? and password=?";
		Query<Profile> query2=session.createQuery(query);
		query2.setParameter(0, userId);
		query2.setParameter(1, password);
		Profile profile=query2.getSingleResult();
		if(profile!=null)
			return true;
		else
			return false;
		}catch(Exception e){
		e.printStackTrace();
			return false;
		}
		
		}
	
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public int setUserStatus(String userId)
	{
		try{
		int currentStatus=getUserStatus(userId);
		currentStatus=currentStatus+1;
		Session session=sessionFactory.getCurrentSession();
		String query="from Profile where id=?";
		Query<Profile> query2=session.createQuery(query);
		query2.setParameter(0, userId);
		Profile profile=query2.getSingleResult();
		profile.setStatus(currentStatus);
		return 1;
		}catch(Exception e){
		return -1;
		}
	}
	@Override
	@Transactional(readOnly=true)
	public boolean authenticateUserId(String userId)
	{
		try{
		Session session=sessionFactory.getCurrentSession();
		String query="from Profile where userId=?";
		Query<Profile> query2=session.createQuery(query);
		query2.setParameter(0, userId);
		Profile profile=query2.getSingleResult();
		if(profile==null)
			return false;
		else
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public int resetUserStatus(String userId){
	
		try{
		Session session=sessionFactory.getCurrentSession();
		String query="from Profile where userId=?";
		Query<Profile> query2=session.createQuery(query);
		query2.setParameter(0, userId);
		Profile profile=query2.getSingleResult();
		profile.setStatus(0);
		return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	@Override
	@SuppressWarnings("null")
	@Transactional(readOnly=true)
	public Profile getUserProfile(String userId)
	{
		try{
		Session session=sessionFactory.getCurrentSession();
		String query="from Profile where userId=?";
		Query<Profile> query2=session.createQuery(query);
		query2.setParameter(0, userId);
		Profile profile=query2.getSingleResult();
		return profile;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
