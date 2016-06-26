package com.datasure.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.datasure.login.dao.CategoryDao;
import com.datasure.login.domain.Category;
import com.datasure.login.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getCategoryByGrade(int grade) {

		//调用categoryDao获取目录
		List<Category> list = new ArrayList<Category>();
		String hql = "select c from Category as c where c.categorygrade="+grade;
		list = categoryDao.getCategory(hql);
		return list;
	}

	
	
	
	/** getter && setter ***/
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

}
