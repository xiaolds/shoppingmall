package com.datasure.login.dao;

import java.util.List;

import com.datasure.common.dao.BaseDao;
import com.datasure.login.domain.Product;
import com.datasure.login.domain.User;

public interface ProductDao extends BaseDao<Product> {

	/**
	 * 
	 * getProduct:(通过字段查找产品). <br/>
	 * @author LiDongSheng
	 * @param key
	 * @param value
	 * @return
	 */
	public List<Product> getProduct(String key, String value);
	
	/**
	 * 
	 * getProduct:(根据id批量获取商品). <br/>
	 * @author LiDongSheng
	 * @param productId
	 * @return
	 */
	public List<Product> getProduct(int...productId);
	
	/**
	 * 
	 * getProductFromShopcart:(根据用户获取其名下的商品). <br/>
	 * @author LiDongSheng
	 * @param user
	 * @return
	 */
	public List<Product> getProductFromShopcart(User user);
	
}
