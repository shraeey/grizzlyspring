package com.cts.grizzly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly.bean.Login;
import com.cts.grizzly.dao.LoginDAO;

@Service("loginService")
@Transactional(propagation=Propagation.SUPPORTS)
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public Login Validate(Login login) {
		// TODO Auto-generated method stub
		return loginDAO.Validate(login);
	}

	@Override
	public String register(Login login) {
		// TODO Auto-generated method stub
		return loginDAO.register(login);
	}

	public Login IncreaseCount(Login userName) {
		// TODO Auto-generated method stub
		return loginDAO.IncreaseCount(userName);
	}

	@Override
	public void resetCount(Login login) {
		// TODO Auto-generated method stub
		loginDAO.resetCount(login);
	}

}
