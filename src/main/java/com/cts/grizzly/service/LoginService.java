package com.cts.grizzly.service;

import com.cts.grizzly.bean.Login;

public interface LoginService {
	public Login Validate(Login login);
	public String register(Login login);
	public Login IncreaseCount(Login login);
	public void resetCount(Login login);
}
