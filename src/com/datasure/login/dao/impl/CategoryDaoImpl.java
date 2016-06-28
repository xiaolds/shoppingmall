package com.datasure.login.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.datasure.common.dao.impl.BaseDaoHibernate3;
import com.datasure.login.dao.CategoryDao;
import com.datasure.login.domain.Category;

public class CategoryDaoImpl extends BaseDaoHibernate3<Category> 
										implements CategoryDao {

	@Override
	public List<Category> getCategory(String hql) throws DataAccessException{
		List<Category> categoryList = null;
		try{
			categoryList = find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return categoryList;
	}



}
