package com.cts.grizzlyspring.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlyspring.bean.Vendors;

@Repository("vendorDAO")
@Transactional(propagation=Propagation.SUPPORTS)
public class VendorDAOImpl implements VendorDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly=true)
	public Vendors getVendorById(String id)
	{
		try{
		Session session=sessionFactory.getCurrentSession();
		String query="from Vendor where id=?";
		Query<Vendors> query2=session.createQuery(query);
		query2.setParameter(0, id);
		Vendors vendor=query2.getSingleResult();
		return vendor;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
}
