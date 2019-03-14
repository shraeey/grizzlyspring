package com.cts.grizzlyspring.service;

import com.cts.grizzlyspring.bean.Vendors;
import com.cts.grizzlyspring.dao.VendorDAOImpl;

public class VendorServiceImpl implements VendorService {
	private VendorDAOImpl dao = new VendorDAOImpl();
	
	public Vendors getVendorById(String id) {
		// TODO Auto-generated method stub
		return dao.getVendorById(id);
	}

}
