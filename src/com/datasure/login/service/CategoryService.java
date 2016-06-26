package com.datasure.login.service;

import java.util.List;

import com.datasure.login.domain.Category;

public interface CategoryService {
	
	
	/**
	 * 
	 * getCategoryByGrade:根据商品等级进行查询. <br/>
	 * @author LiDongSheng
	 * @param grade
	 * @return
	 */
	public List<Category> getCategoryByGrade(int grade);
	

}
