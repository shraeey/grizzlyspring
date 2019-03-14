package com.cts.grizzlyspring.service;

import com.cts.grizzlyspring.bean.Profile;

public interface LoginService {
	public int getUserStatus(String userId);
	public int setUserStatus(String userId);
	public int resetUserStatus(String userId);
	public Profile getUserProfile(String userId);
	public String getUserType(String userId,String password);
	public boolean authenticate(String userId,String password);
	public String authorization(String userName,String password);
	public boolean authenticateUserId(String userId);
	
}
