package com.cts.grizzly.dao;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.cts.grizzly.bean.Login;

public interface LoginDAO {

	public Login Validate(Login login);
	public String register(Login login);
	public Login IncreaseCount(Login login);
	public void resetCount(Login login);
}
