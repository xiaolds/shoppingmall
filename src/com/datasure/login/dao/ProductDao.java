package com.datasure.login.dao;

import java.util.List;

import com.datasure.common.dao.BaseDao;
import com.datasure.login.domain.Product;

public interface ProductDao extends BaseDao<Product> {

	/**
	 * 
	 * getProduct:(ͨ���ֶβ��Ҳ�Ʒ). <br/>
	 * @author LiDongSheng
	 * @param key
	 * @param value
	 * @return
	 */
	public List<Product> getProduct(String key, String value);
	
}
