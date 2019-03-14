package com.cts.grizzlyspring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlyspring.bean.Profile;

@Repository("employeeDAO")
@Transactional(propagation=Propagation.SUPPORTS)
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int registerUser(Profile employee) {
		try{
		Session session=sessionFactory.getCurrentSession();
		session.save(employee);
		return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
}
}
