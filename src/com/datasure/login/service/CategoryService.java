package com.datasure.login.service;

import java.util.List;

import com.datasure.login.domain.Category;

public interface CategoryService {
	
	
	/**
	 * 
	 * getCategoryByGrade:������Ʒ�ȼ����в�ѯ. <br/>
	 * @author LiDongSheng
	 * @param grade
	 * @return
	 */
	public List<Category> getCategoryByGrade(int grade);
	

}
