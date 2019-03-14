package com.cts.grizzlyspring.service;

import com.cts.grizzlyspring.bean.Profile;
import com.cts.grizzlyspring.dao.EmployeeDAO;
import com.cts.grizzlyspring.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO dao = new EmployeeDAOImpl();
	@Override
	public int registerUser(Profile employee) {
		// TODO Auto-generated method stub
		return dao.registerUser(employee);
	}

}
