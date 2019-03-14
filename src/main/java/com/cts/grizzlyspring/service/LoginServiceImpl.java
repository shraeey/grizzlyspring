package com.cts.grizzlyspring.service;

import com.cts.grizzlyspring.service.LoginServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlyspring.bean.Profile;
import com.cts.grizzlyspring.dao.LoginDAO;
@Service("loginService")
@Transactional(propagation=Propagation.SUPPORTS)
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public int getUserStatus(String userId) {
	return loginDAO.getUserStatus(userId);
	}

	@Override
	public String getUserType(String userId,String password) {
		return loginDAO.getUserType(userId,password);

	}

	@Override
	public boolean authenticate(String userId,String password) {
		return loginDAO.authenticate(userId,password);

	}
	
	@Override
	public String authorization(String userName,String password)
	{
		return "false";
	}
	
	@Override
	public int setUserStatus(String userId)
	{
	return loginDAO.setUserStatus(userId);
	}
	
	@Override
	public boolean authenticateUserId(String userId)
	{
		return loginDAO.authenticateUserId(userId);
	}
	
	@Override
	public int resetUserStatus(String userId)
	{
		return loginDAO.resetUserStatus(userId);
	}
	



	@Override
	public Profile getUserProfile(String userId) {
		// TODO Auto-generated method stub
		return loginDAO.getUserProfile(userId);
	}}
