package com.cts.grizzlyspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlyspring.bean.Category;
import com.cts.grizzlyspring.dao.CategoryDAO;
import com.cts.grizzlyspring.dao.CategoryDAOImpl;

@Service("categoryService")
@Transactional(propagation=Propagation.SUPPORTS)
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Category> getCategory() {
		return  categoryDAO.getCategory();
	}

}
