package com.datasure.login.dao;

import java.util.List;

import com.datasure.common.dao.BaseDao;
import com.datasure.login.domain.Product;
import com.datasure.login.domain.User;

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
	
	/**
	 * 
	 * getProduct:(����id������ȡ��Ʒ). <br/>
	 * @author LiDongSheng
	 * @param productId
	 * @return
	 */
	public List<Product> getProduct(int...productId);
	
	/**
	 * 
	 * getProductFromShopcart:(�����û���ȡ�����µ���Ʒ). <br/>
	 * @author LiDongSheng
	 * @param user
	 * @return
	 */
	public List<Product> getProductFromShopcart(User user);
	
}
