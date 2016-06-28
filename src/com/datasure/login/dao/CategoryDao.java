package com.datasure.login.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.datasure.common.dao.BaseDao;
import com.datasure.login.domain.Category;

public interface CategoryDao extends BaseDao<Category> {
	
	/**
	 * 
	 * getCategory:ʹ��HQL��������Ʒ����Ĳ�ѯ. <br/>
	 * @author LiDongSheng
	 * @param hql
	 * @return
	 */
	public List<Category> getCategory(String hql) throws DataAccessException;

}
