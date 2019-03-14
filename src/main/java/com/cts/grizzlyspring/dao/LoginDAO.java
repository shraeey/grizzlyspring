package com.cts.grizzlyspring.dao;

import com.cts.grizzlyspring.bean.Profile;

public interface LoginDAO {
	public int getUserStatus(String userId);
	public int setUserStatus(String userId);
	public Profile getUserProfile(String userId);
	public int resetUserStatus(String userId);
	public String getUserType(String userId,String password);
	public boolean authenticate(String userId,String password);
	public boolean authenticateUserId(String userId);
	

}
